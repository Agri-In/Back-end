package com.audit.agriin.Domains.DTOs.Entities.LMR;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.Enums.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.LMR}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LMRResponse extends AbstractResponse<UUID> {
    Region region;
    String residue_mg_kg;
    UUID drugId;
    String drugName;
}