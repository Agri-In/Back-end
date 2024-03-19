package com.audit.agriin.Domains.DTOs.Entities.ActiveMatter;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.ActiveMatter}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ActiveMatterRequest(String name) implements _Request {
}