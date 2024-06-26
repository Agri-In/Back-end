package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.User.ChangeGroupRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.ChangePasswordRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.UserRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.UserResponses;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.Token;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Domains.Enums.TokenType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.audit.agriin.Exceptions.NoAuthenticateUser;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Exceptions.ResourceNotFoundException;
import com.audit.agriin.Mapper.UserMapper;
import com.audit.agriin.Repositories.GroupRepository;
import com.audit.agriin.Repositories.TokenRepository;
import com.audit.agriin.Repositories.UserRepository;
import com.audit.agriin.Services.Specification.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing user-related operations.
 *
 * <p>This service class provides methods for retrieving user data based on various criteria,
 * updating user information, and handling user status changes.</p>
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 * @version 1.0
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
@CacheConfig(cacheNames = "Users")
public class UserServiceImpl extends _ServiceImp<UUID, UserRequest, UserResponses, User, UserRepository, UserMapper> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;

    public User saveUser(User user) {
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new ResourceNotCreatedException("User not created");
        }
    }

    @Override
    @CachePut(
            key = "#request.id"
    )
    public Optional<UserResponses> update(UserResponses request) {
        User userToUpdate = mapper.toEntityFromResponse(request);
        User user = repository.findById(userToUpdate.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setUserGroups(userToUpdate.getUserGroups());
        user.setEnabled(userToUpdate.isEnabled());
        return Optional.of(
                mapper.toResponse(repository.saveAndFlush(user))
        );
    }

    /**
     * Retrieves the currently authenticated user.
     * <p>
     * This method fetches the current user's details from the Spring Security context.
     * It performs checks to ensure that there is an authenticated user and that the user
     * is not an instance of {@link AnonymousAuthenticationToken}.
     * </p>
     */
    public UserResponses getCurrentUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken)
            throw new NoAuthenticateUser("User not authenticated");

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = findUserByEmail(userDetails.getUsername());
        return mapper.toResponse(user);
    }

    /**
     * Changes the group of the specified user.
     *
     * @param changeGroupRequest The request containing the user and the new group.
     * @return The updated user.
     */
    @Override
//    @PreAuthorize("hasAuthority('QUALITY_MANAGER')")
    public UserResponses changeGroup(ChangeGroupRequest changeGroupRequest) {
        try {
            User user = this.findUserByEmail(changeGroupRequest.email());
            Group group = groupRepository.findGroupByName(changeGroupRequest.groupName());
            user.getUserGroups().add(group);
            user.setUserGroups(user.getUserGroups());
            return mapper.toResponse(repository.save(user));
        } catch (Exception e) {
            throw new ResourceNotCreatedException("User Role not updated");
        }
    }


    /**
     * Retrieves a paginated list of manager users.
     *
     * @param group the group
     * @param pageable The pagination information.
     * @return A paginated list of the group users.
     */
//    @Cacheable("managers")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<UserResponses> getAllByGroup(Group group, Pageable pageable) {
        return repository.findAllByUserGroupsContaining(group , pageable)
                .map(mapper::toResponse);
    }


    /**
     * Retrieves a user by email.
     *
     * @param email The email of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
//    @PreAuthorize("hasAuthority('ADMIN')"):
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    /**
     * Retrieves a user by ID.
     *
     * @param username The ID of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
//    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> findById(UUID username) {
        return repository.findById(username);
    }


    /**
     * Changes the password of the currently logged-in user.
     *
     * @param request       The change password request.
     * @param connectedUser The principal representing the currently connected user.
     * @throws IllegalStateException If the current password is incorrect, or if the new passwords do not match.
     */
    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.newPassword().equals(request.confirmationPassword())) {
            throw new IllegalStateException("Passwords are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));

        repository.save(user);
    }

    /**
     * Updates the status of the specified user to offline.
     *
     * @param user The user to update.
     */
    public void disconnect(User user) {
        if (user != null) {
            user.setStatus(UserStatus.OFFLINE);
            repository.save(user);
        }
    }

    /**
     * Retrieves a paginated list of connected users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of connected users.
     */
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Page<UserResponses> findConnectedUsers(Pageable pageable) {
        return repository.findAllByStatus(UserStatus.ONLINE, pageable)
                .map(mapper::toResponse);
    }


    /**
     * Saves a new user token to the database.
     *
     * @param user     User for whom the token is generated
     * @param jwtToken JWT token to be saved
     */
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    /**
     * Revokes all valid tokens for a user by marking them as expired and revoked.
     *
     * @param user User for whom tokens are revoked
     */
//    @PreAuthorize("hasAuthority('ADMIN')")
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (!validUserTokens.isEmpty()) {
            validUserTokens.forEach(token -> {
                token.setExpired(true);
                token.setRevoked(true);
            });
            tokenRepository.saveAll(validUserTokens);
        }
    }
}