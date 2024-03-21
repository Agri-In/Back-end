package com.audit.agriin.Domains.DTOs.Entities.AccountManager;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.AccountManager}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountManagerResponse extends AbstractResponse<UUID> {
    @Size(message = "Password must be at least 8 characters long.", min = 8)
    @NotBlank(message = "password cannot be blank.")
    String password;
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
    Set<String> userGroupNames;
    String qualityManagerEmail;
    String qualityManagerFirstname;
    String qualityManagerLastname;
    String managedCompanyLegalName;
}