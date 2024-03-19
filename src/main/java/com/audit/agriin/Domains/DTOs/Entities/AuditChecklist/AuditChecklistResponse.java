package com.audit.agriin.Domains.DTOs.Entities.AuditChecklist;

import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.File;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.AuditChecklist}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditChecklistResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id,
                                     String checklistName, AuditTypeResponse auditType,
                                     List<File> storageFiles) implements  _Response {
}