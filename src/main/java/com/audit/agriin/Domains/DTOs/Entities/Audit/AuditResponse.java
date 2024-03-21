package com.audit.agriin.Domains.DTOs.Entities.Audit;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.FirmResponsible;
import com.audit.agriin.Domains.Enums.AuditStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Audit}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditResponse extends AbstractResponse<UUID> {
    Timestamp date;
    AuditTypeResponse auditType;
    List<FirmResponse> firms;
    List<FileResponse> storageFiles;
    AuditStatus status;


}