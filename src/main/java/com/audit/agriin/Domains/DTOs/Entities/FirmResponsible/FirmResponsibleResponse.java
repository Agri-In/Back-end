package com.audit.agriin.Domains.DTOs.Entities.FirmResponsible;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.FirmResponsible}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirmResponsibleResponse extends AbstractResponse<UUID> {
    @Size(message = "Lastname is too long", max = 30)
    String lastname;
    Gender gender;
    String nationality;
    @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}")
    String phoneNumber;
    String managedCompanyLegalName;
    List<Firm> firmAssignmentFirms;
    List<Boolean> firmAssignmentInDuties;
}