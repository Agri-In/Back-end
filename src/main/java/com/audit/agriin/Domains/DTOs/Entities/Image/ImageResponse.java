package com.audit.agriin.Domains.DTOs.Entities.Image;

import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Common.Image}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ImageResponse(Timestamp createdAt, String name, String type, @URL String url) implements _Response {
}