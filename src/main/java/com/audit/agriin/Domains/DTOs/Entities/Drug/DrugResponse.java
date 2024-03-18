package com.audit.agriin.Domains.DTOs.Entities.Drug;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Drug}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DrugResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String commercialName,
                           String description, double dosage, DosageUnit dosageUnit, int dar, int maxApplication,
                           DrugType drugType, DrugCharacter drugCharacter) implements _Response {
}