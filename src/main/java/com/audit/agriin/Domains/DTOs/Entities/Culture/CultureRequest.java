package com.audit.agriin.Domains.DTOs.Entities.Culture;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Culture}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CultureRequest(String name, String description, UUID varietyId) implements _Request {
}