package com.audit.agriin.Domains.DTOs.Entities.AuditType;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Domains.Entities.Business.AuditChecklist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.AuditType}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditTypeResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name,
                                String description, AuditChecklist auditChecklist,
                                List<Audit> audits) implements _Response {
}