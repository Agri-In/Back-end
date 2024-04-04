package com.audit.agriin.Domains.DTOs.Entities.Treatment;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Enums.ConcentrationUnit;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Domains.Enums.TreatmentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record TreatmentRequest(
        List<UUID> parcelIds,
        UUID drugId,
        Date applicationDate,
        Time applicationStartTime,
        Time applicationEndTime,
        ConcentrationUnit concentrationUnit,
        double totalQuantity,
        TreatmentType treatmentType,
        DrugApplicationStage drugApplicationStage,
        UUID operatorId,
        String observation,
        String materials
) implements _Request {
}