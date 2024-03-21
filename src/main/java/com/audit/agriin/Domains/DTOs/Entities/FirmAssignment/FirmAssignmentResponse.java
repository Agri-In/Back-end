package com.audit.agriin.Domains.DTOs.Entities.FirmAssignment;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Common.FirmAssignment}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirmAssignmentResponse extends AbstractResponse<UUID> {
    String firmResponsibleFirstname;
    String firmResponsibleLastname;
    String firmResponsiblePhoneNumber;
    String firmName;
    boolean inDuty;
}