package com.audit.agriin.Domains.DTOs.Entities.Group;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.Group}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GroupResponse(UUID id, String code, String name, Set<UserDto> users) implements _Response {
    /**
     * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.User}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record UserDto(String phoneNumber, String email, String firstname, String lastname,
                          IdentityDocumentType identityDocumentType,
                          String identityDocumentNumber) implements _Response {
    }
}