package com.audit.agriin.Domains.DTOs.Entities.FirmAssignment;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Common.FirmAssignment}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmAssignmentRequest(UUID firmResponsibleId, UUID firmId, boolean inDuty) implements _Request {
}