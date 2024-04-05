package com.audit.agriin.Domains.DTOs.Entities.User;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record ChangeGroupRequest(
        @NotBlank(message = "User is required")
        String email,

        @NotNull(message = "Group names is required")
        String groupName

) implements _Request {
}
