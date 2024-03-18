package com.audit.agriin.Domains.DTOs.Entities.Variety;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Variety}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record VarietyRequest(String name, String description, UUID cultureId) implements _Request {
}