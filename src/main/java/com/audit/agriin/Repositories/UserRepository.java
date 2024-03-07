package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Domains.Enums.UserStatus;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link User} entities in the database.
 */

@Repository
@NonNullApi
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by their email address.
     *
     * @param email The email address of the user.
     * @return An optional containing the user, or empty if not found.
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user.
     * @return An optional containing the user, or empty if not found.
     */
    Optional<User> findById(UUID id);

    /**
     * Retrieves a page of all users.
     *
     * @param pageable Pageable object for pagination.
     * @return A page containing all users.
     */
    Page<User> findAll(Pageable pageable);

    /**
     * Retrieves a page of users with a specific status.
     *
     * @param status   The status of the users to retrieve.
     * @param pageable Pageable object for pagination.
     * @return A page of users with the specified status.
     */
    Page<User> findAllByStatus(UserStatus status, Pageable pageable);

    /**
     * Retrieves a page of users with a specific role.
     *
     * @param role     The role of the users to retrieve.
     * @param pageable Pageable object for pagination.
     * @return A page of users with the specified role.
     */
    Page<User> findAllByUserGroupsContaining(Group role, Pageable pageable);
}
