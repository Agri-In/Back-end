package com.audit.agriin.Domains.DTOs.Entities.User;

import com.audit.agriin.Domains.DTOs._Request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for authentication requests.
 * This class represents the data sent when a user is trying to authenticate.
 * It includes the user's email and password.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 */
public record AuthenticationRequest(
        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
        String password
) implements _Request {
}
