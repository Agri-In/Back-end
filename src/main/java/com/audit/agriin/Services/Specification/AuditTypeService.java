package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;

import java.util.UUID;

public interface AuditTypeService extends _Service<AuditTypeRequest, AuditTypeResponse, UUID>{

    AuditTypeResponse getAuditTypeById(UUID id);
}
