package com.audit.agriin.Domains.DTOs.Entities.Enemy;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Enemy}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnemyResponse extends AbstractResponse<UUID> {
    String name;
    String drugCommercialName;
}