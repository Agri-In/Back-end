package com.audit.agriin.Domains.DTOs.Entities.User;

import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import jakarta.validation.constraints.*;

import java.sql.Date;

/**
 * DTO for creating or updating a {@link com.audit.agriin.Domains.Entities.NonCorporate.User} entity.
 * Represents a user request with details such as password, image, phone number,
 * email, first name, last name, gender, and address.
 */
public record UserRequest(
        @Size(message = "Password must be at least 8 characters long.", min = 8) @NotBlank(message = "password cannot be blank.")
        String password,

        String image,

        @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}")
        String phoneNumber,
        @Size(message = "Email is too long", max = 80) @Email(message = "Email was not provided")
        String email,
        @NotNull(message = "FirstName must be present") @Size(message = "Firstname cannot be empty", min = 1)
        String firstname,
        @Size(message = "Lastname is too long", max = 30)
        String lastname,
        Gender gender,
        String nationality,
        Date birthDate,
        IdentityDocumentType identityDocumentType,
        String identityDocumentNumber,
        AddressDto address,
        boolean accountNonLocked
) implements _Request {
}