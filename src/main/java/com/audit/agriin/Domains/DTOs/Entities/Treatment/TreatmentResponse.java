package com.audit.agriin.Domains.DTOs.Entities.Treatment;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Enums.ConcentrationUnit;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Domains.Enums.TreatmentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Treatment}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TreatmentResponse extends AbstractResponse<UUID> {
    UUID id;
    List<ParcelResponse> parcels;
    DrugDto drug;
    String drugCommercialName;
    Date applicationDate;
    Time applicationStartTime;
    Time applicationEndTime;
    double quantity;
    ConcentrationUnit concentrationUnit;
    double bouillie;
    double totalQuantity;
    double concentration;
    TreatmentType treatmentType;
    DrugApplicationStage drugApplicationStage;
    String operatorFullName;
    String operatorPhone;
    String observation;
    String materials;

    /**
     * DTO for {@link com.audit.agriin.Domains.Entities.Business.Drug}
     */

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DrugDto(UUID id, double dosage) implements _Response {
    }
}