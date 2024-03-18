package com.audit.agriin.Domains.DTOs.Entities.User;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record ChangeGroupRequest(
        @NotBlank(message = "User is required")
        UserResponses user,

        @NotNull(message = "Role is required")
        Set<Group> groups

) implements _Request {
}
