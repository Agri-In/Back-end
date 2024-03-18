package com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis;

import com.audit.agriin.Domains.DTOs.Entities.File.FileRequest;
import com.audit.agriin.Domains.DTOs._Request;
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
public record FirmAnalysisRequest(String name, String description, LocalDate date, Timestamp storageCreatedAt,
                                  Timestamp storageUpdatedAt, Long storageVersion, UUID storageId,
                                  List<FileRequest> storageFiles, UUID firmId) implements _Request {
}