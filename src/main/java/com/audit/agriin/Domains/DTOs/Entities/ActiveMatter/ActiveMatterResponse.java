package com.audit.agriin.Domains.DTOs.Entities.ActiveMatter;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.ActiveMatter}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ActiveMatterResponse(UUID id, String name, List<DrugResponse> drugs) implements _Response {
}