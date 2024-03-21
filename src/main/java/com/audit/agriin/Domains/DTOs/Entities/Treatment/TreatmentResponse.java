package com.audit.agriin.Domains.DTOs.Entities.Treatment;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Enums.ConcentrationUnit;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Domains.Enums.TreatmentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class TreatmentResponse extends AbstractResponse<UUID> {
    UUID id;
    List<ParcelResponse> parcels;
    UUID drugId;
    String drugCommercialName;
    LocalDate applicationDate;
    LocalTime applicationStartTime;
    LocalTime applicationEndTime;
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
}