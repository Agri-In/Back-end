package com.audit.agriin.Domains.DTOs.Entities.Group;

import com.audit.agriin.Domains.DTOs.Entities.User.UserResponses;
import com.audit.agriin.Domains.DTOs._Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ChangeRoleRequest(
        @NotBlank(message = "User is required")
        UserResponses user,

        @NotNull(message = "Role is required")
        UUID groupId

) implements _Request {
}
