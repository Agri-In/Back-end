package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import com.audit.agriin.Domains.Entities.Business.Audit;

import java.util.Optional;
import java.util.UUID;

public interface AuditService extends _Service<AuditRequest, AuditResponse, UUID>{
    /**
     * Retrieves a audit by its unique identifier.
     *
     * @param id The unique identifier of the competition.
     * @return An optional containing the competition, or empty if not found.
     */
    Optional<Audit> getAuditById(UUID id);
}
