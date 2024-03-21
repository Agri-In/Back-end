package com.audit.agriin.Domains.DTOs.Entities.ExternalConsultant;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.ExternalConsultant}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalConsultantResponse extends AbstractResponse<UUID> {
    @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}")
    String phoneNumber;
    @Size(message = "Email is too long", max = 80)
    @Email(message = "Email was not provided")
    String email;
    @NotNull(message = "FirstName must be present")
    @Size(message = "Firstname cannot be empty", min = 1)
    String firstname;
    @Size(message = "Lastname is too long", max = 30)
    String lastname;
    Gender gender;
    String nationality;
    UserStatus status;
    Date birthDate;
    IdentityDocumentType identityDocumentType;
    String identityDocumentNumber;
    AddressDto address;
    UUID consultancyFirmId;
    String consultancyFirmLegalName;
}