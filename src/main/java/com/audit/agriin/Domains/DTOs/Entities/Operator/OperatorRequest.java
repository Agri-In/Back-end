package com.audit.agriin.Domains.DTOs.Entities.Operator;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Operator}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OperatorRequest(String fullName, String phone) implements _Request {
}