package com.audit.agriin.Domains.DTOs.Entities.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO class representing the response for authentication.
 * Contains access and refresh tokens.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {
    /**
     * Access token for authentication.
     */
    @NotBlank(message = "Access token is required")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Refresh token for token refreshing.
     */
    @NotBlank(message = "Refresh token is required")
    @JsonProperty("refresh_token")
    private String refreshToken;
}