package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.User.AuthenticationRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.AuthenticationResponse;
import com.audit.agriin.Domains.DTOs.Entities.User.RegisterRequest;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.audit.agriin.Exceptions.AuthenticationFailedException;
import com.audit.agriin.Exceptions.NoAuthenticateUser;
import com.audit.agriin.Repositories.GroupRepository;
import com.audit.agriin.Services.Specification.AuthenticationService;
import com.audit.agriin.Services.Specification.JwtService;
import com.audit.agriin.Services.Specification.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the Service class {@link AuthenticationService} for user authentication and token management.
 * This service provides methods to register a new user, authenticate a user, and refresh access tokens.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">Nouhi Sidati</a>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final GroupRepository groupRepository;

    /**
     * Registers a new user and generates access and refresh tokens.
     *
     * @param request Registration request containing user details
     * @return AuthenticationResponse containing access and refresh tokens
     */
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        var group = groupRepository.findGroupByName("DEFAULT_USER");
        return registerUser(request, group);
    }

    /**
     * Creates a new user based on the registration request and assigns a specified role.
     * This method involves setting up a new user with the provided details, encoding the password,
     * and saving the user to the database.
     * It then generates JWT access and refresh tokens for the
     * new user and saves these tokens.
     * This process is essential for registering new users and
     * providing them with the necessary tokens to access secured endpoints.
     *
     * @param request The registration request containing the new user's details such as name, email, and password.
     * @param group   The role to be assigned to the new user, which determines the user's permissions and access.
     * @return AuthenticationResponse containing the generated JWT access and refresh tokens.
     */
    @Transactional
    public AuthenticationResponse registerUser(RegisterRequest request, Group group) {
        log.info("Creating a new user with group: {}", group);

        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .status(UserStatus.ONLINE)
                .enabled(true)
                .accountNonLocked(true)
                .password(passwordEncoder.encode(request.password()))
                .failedLoginAttempts(0)
                .loginDisabled(false)
                .build();

        user.setUserGroups(Set.of(group));

        var savedUser = userService.saveUser(user);
        log.info("User with ID {} created successfully.", savedUser.getId());

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        userService.saveUserToken(savedUser, jwtToken);
        log.info("Access and refresh tokens generated and saved for user with ID: {}", savedUser.getId());

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     * Authenticates a user and generates new access and refresh tokens.
     *
     * @param request Authentication request containing user credentials
     * @return AuthenticationResponse containing new access and refresh tokens
     */
    @Transactional
//    @PreAuthorize("hasAnyAuthority('DEFAULT_USER', 'ADMIN', 'ACCOUNT_MANAGER', 'QUALITY_MANAGER')")
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticateUser(request.email(), request.password());
        User user = userService.findUserByEmail(request.email());
        return createAndSaveTokens(user);
    }

    /**
     * Refreshes the JWT access token using a valid refresh token.
     *
     * @param request  HttpServletRequest containing the refresh token in the authorization header.
     * @param response HttpServletResponse to write the new access token.
     * @throws IOException if an error occurs during response writing.
     */
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var refreshToken = extractRefreshToken(request);
        var user = userService.findUserByEmail(
                jwtService.extractUsername(refreshToken)
        );

        if (jwtService.isTokenValid(refreshToken, user)) {
            var authResponse = createAndSaveTokens(user);
            new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
        }
    }

    /**
     * Checks whether a token is valid.
     *
     * @param token Token to be checked
     * @return True if the token is valid, false otherwise
     */
    public Boolean checkToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return false;
        }
        String jwt = token.substring(7);

        var userEmail = jwtService.extractUsername(jwt);

        if (userEmail != null) {
            var user = userService.findUserByEmail(userEmail);
            var isValid = jwtService.isTokenValid(jwt, user);

            if (!isValid)
                throw new NoAuthenticateUser("Invalid token");

            return true;
        }

        throw new NoAuthenticateUser("Invalid token");
    }

    /**
     * Handles user authentication and throws appropriate exceptions on failure.
     *
     * @param email    The email of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @throws com.audit.agriin.Exceptions.AuthenticationFailedException if authentication fails.
     */
    private void authenticateUser(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException ex) {
            log.error("Invalid credentials for user: {}", email, ex);
            throw new BadCredentialsException("Invalid credentials");
        } catch (AuthenticationException ex) {
            log.error("Authentication failed for user: {}", email, ex);
            throw new AuthenticationFailedException("Authentication failed");
        }
    }

    /**
     * Generates JWT access and refresh tokens for the user, saves them, and returns an authentication response.
     *
     * @param user The user for whom to create and save tokens.
     * @return AuthenticationResponse containing generated access and refresh tokens.
     */
    private AuthenticationResponse createAndSaveTokens(User user) {
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        user.setStatus(UserStatus.ONLINE);
        userService.saveUser(user);
        userService.revokeAllUserTokens(user);
        userService.saveUserToken(user, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     * Extracts the refresh token from the HTTP request.
     *
     * @param request HttpServletRequest containing the authorization header.
     * @return Extracted refresh token.
     * @throws AuthenticationFailedException if the token format is invalid.
     */
    private String extractRefreshToken(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new AuthenticationFailedException("Invalid token format");
        }
        return authHeader.substring(7);
    }

}