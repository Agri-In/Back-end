package com.audit.agriin.Domains.DTOs.Entities.Drug;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.audit.agriin.Domains.Enums.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Drug}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugResponse extends AbstractResponse<UUID> {
    Timestamp createdAt;
    Timestamp updatedAt;
    Long version;
    UUID id;
    String commercialName;
    String description;
    Set<ActiveMatterResponse> activeMatters;
    double dosage;
    DosageUnit dosageUnit;
    Set<String> enemyNames;
    int dar;
    int maxApplication;
    Set<LMRResponse> lmrs;
    DrugType drugType;
    DrugCharacter drugCharacter;

}