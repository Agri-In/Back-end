package com.audit.agriin.Domains.DTOs.Entities.FirmAssignment;

import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.DTOs.Entities.FirmResponsible.FirmResponsibleResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Common.FirmAssignment}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmAssignmentResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id,
                                     FirmResponsibleResponse firmResponsible, FirmResponse firm,
                                     boolean inDuty) implements _Response {
}