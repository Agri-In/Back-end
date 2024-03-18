package com.audit.agriin.Domains.DTOs.Entities.Group;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.Group}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GroupRequest(String code, String name) implements _Request {
}