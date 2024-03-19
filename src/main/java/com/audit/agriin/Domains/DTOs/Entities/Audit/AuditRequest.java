package com.audit.agriin.Domains.DTOs.Entities.Audit;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Audit}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditRequest(LocalDate date, UUID auditTypeId, List<UUID> firmIds) implements _Request {
}