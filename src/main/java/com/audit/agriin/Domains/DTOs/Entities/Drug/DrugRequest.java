package com.audit.agriin.Domains.DTOs.Entities.Drug;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Drug}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record DrugRequest(
        String commercialName,
        String description,
        Set<UUID> activeMatterIds,
        double dosage,
        DosageUnit dosageUnit,
        int dar,
        int maxApplication,
        Set<LMRRequest> lmrs,
        DrugType drugType,
        DrugCharacter drugCharacter
) implements _Request {
}