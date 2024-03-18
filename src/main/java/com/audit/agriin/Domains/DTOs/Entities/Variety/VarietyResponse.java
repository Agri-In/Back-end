package com.audit.agriin.Domains.DTOs.Entities.Variety;

import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Variety}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record VarietyResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name,
                              String description, CultureResponse culture) implements _Response {
}