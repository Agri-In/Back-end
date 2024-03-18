package com.audit.agriin.Domains.DTOs.Entities.LMR;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.LMR}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LMRRequest(Region region, String residue_mg_kg, UUID activeMatterId) implements _Request {
}