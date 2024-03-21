package com.audit.agriin.Domains.DTOs.Entities.Variety;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Variety}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VarietyResponse extends AbstractResponse<UUID> {
    String name;
    String description;
}