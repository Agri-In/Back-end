package com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis;

import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.audit.agriin.Domains.DTOs.Entities.FileOwner.FileOwnerDto;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.FirmAnalysis}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmAnalysisResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name,
                                   String description, LocalDate date, FileOwnerDto storage,
                                   String firmName) implements _Response {
}