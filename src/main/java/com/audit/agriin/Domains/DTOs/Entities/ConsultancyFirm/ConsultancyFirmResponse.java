package com.audit.agriin.Domains.DTOs.Entities.ConsultancyFirm;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.Enums.CorporationSize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Corporate.ConsultancyFirm}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultancyFirmResponse extends AbstractResponse<UUID> {
    @NotNull(message = "FirstName must be present")
    @Size(message = "Firstname cannot be empty", min = 1)
    String legalName;
    @Size(message = "Firstname cannot be empty", min = 1)
    String foundationDate;
    AddressDto address;
    @Size(message = "Email is too long", max = 80)
    @Email(message = "Email was not provided")
    String email;
    CorporationSize size;
    @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}")
    String phoneNumber;
    UUID storageId;
}