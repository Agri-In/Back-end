package com.audit.agriin.Domains.DTOs.Entities.LMR;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.LMR}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LMRResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, Region region,
                          String residue_mg_kg, ActiveMatterResponse activeMatter) implements _Response {

}