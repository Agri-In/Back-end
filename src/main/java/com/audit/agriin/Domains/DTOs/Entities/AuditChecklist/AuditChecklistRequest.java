package com.audit.agriin.Domains.DTOs.Entities.AuditChecklist;

import com.audit.agriin.Domains.DTOs.Entities.FileOwner.FileOwnerDto;
import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Entities.Business.File;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.AuditChecklist}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditChecklistRequest(String checklistName, UUID auditTypeId,
                                    FileOwnerDto storage) implements _Request {

}