package com.audit.agriin.Domains.DTOs.Entities.File;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.File}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FileRequest(String name, String type, @URL String url) implements _Request {
}