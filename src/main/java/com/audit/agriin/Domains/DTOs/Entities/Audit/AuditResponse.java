package com.audit.agriin.Domains.DTOs.Entities.Audit;

import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Domains.DTOs.Entities.FileOwner.FileOwnerDto;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.File;
import com.audit.agriin.Domains.Enums.AuditStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Audit}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, LocalDate date,
                            AuditTypeResponse auditType, List<FirmResponse> firms, FileOwnerDto storage,
                            AuditStatus status) implements _Response {
}