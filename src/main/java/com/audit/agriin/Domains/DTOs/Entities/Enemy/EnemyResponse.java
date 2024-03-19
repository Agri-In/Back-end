package com.audit.agriin.Domains.DTOs.Entities.Enemy;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Enemy}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EnemyResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name,
                            DrugResponse drug) implements _Response {
}