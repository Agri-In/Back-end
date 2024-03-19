package com.audit.agriin.Domains.DTOs.Entities.Image;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Common.Image}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ImageRequest(String name, String type, @URL String url, UUID storageId) implements _Request {
}