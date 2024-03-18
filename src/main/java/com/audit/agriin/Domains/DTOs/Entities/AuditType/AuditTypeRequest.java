package com.audit.agriin.Domains.DTOs.Entities.AuditType;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.AuditType}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditTypeRequest(String name, String description) implements _Request {
}