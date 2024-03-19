package com.audit.agriin.Domains.DTOs.Entities.ExternalConsultant;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.ExternalConsultant}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalConsultantResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id,
                                         @Size(message = "Password must be at least 8 characters long.", min = 8) @NotBlank(message = "password cannot be blank.") String password,
                                         @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}") String phoneNumber,
                                         @Size(message = "Email is too long", max = 80) @Email(message = "Email was not provided") String email,
                                         @NotNull(message = "FirstName must be present") @Size(message = "Firstname cannot be empty", min = 1) String firstname,
                                         @Size(message = "Lastname is too long", max = 30) String lastname,
                                         Gender gender, String nationality, UserStatus status, Date birthDate,
                                         IdentityDocumentType identityDocumentType, String identityDocumentNumber,
                                         String addressRegion, String addressDistrict, String addressCity,
                                         String addressStreet, Integer addressBuilding, Integer addressPostalCode,
                                         Set<String> userGroupNames,
                                         String consultancyFirmLegalName) implements _Response {
}