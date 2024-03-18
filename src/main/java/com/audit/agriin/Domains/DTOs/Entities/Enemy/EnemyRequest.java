package com.audit.agriin.Domains.DTOs.Entities.Enemy;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Enemy}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EnemyRequest(String name) implements _Request {
}