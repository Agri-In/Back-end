package com.audit.agriin.Domains.DTOs.Entities.QualityManager;

import com.audit.agriin.Domains.DTOs.Entities.AccountManager.AccountManagerResponse;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;
import com.audit.agriin.Domains.DTOs.Entities.Image.ImageResponse;
import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.QualityManager}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record QualityManagerResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id,
                                     List<ImageResponse> storageImages,
                                     @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}") String phoneNumber,
                                     @Size(message = "Email is too long", max = 80) @Email(message = "Email was not provided") String email,
                                     @NotNull(message = "FirstName must be present") @Size(message = "Firstname cannot be empty", min = 1) String firstname,
                                     @Size(message = "Lastname is too long", max = 30) String lastname, Gender gender,
                                     String nationality, UserStatus status, Date birthDate,
                                     IdentityDocumentType identityDocumentType, String identityDocumentNumber,
                                     String addressRegion, String addressDistrict, String addressCity,
                                     String addressStreet, Integer addressBuilding, Integer addressPostalCode,
                                     Set<GroupResponse> userGroups, boolean enabled, int failedLoginAttempts,
                                     boolean loginDisabled, boolean accountNonLocked,
                                     List<AccountManagerResponse> accountManagers,
                                     ManagedCompanyResponse managedCompany) implements _Response {
}