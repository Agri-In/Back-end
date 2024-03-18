package com.audit.agriin.Domains.DTOs.Entities.FirmResponsible;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.FirmResponsible}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmResponsibleResponse(UUID id,
                                      @NotNull(message = "FirstName must be present") @Size(message = "Firstname cannot be empty", min = 1) String firstname,
                                      @Size(message = "Lastname is too long", max = 30) String lastname, Gender gender,
                                      String nationality,
                                      @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}") String phoneNumber) implements Serializable, _Response {
}