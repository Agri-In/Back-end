package com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.FirmAnalysis}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirmAnalysisResponse extends AbstractResponse<UUID> {
    String name;
    String description;
    LocalDate date;
    List<FileResponse> storageFiles;
    String firmName;
}