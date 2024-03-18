package com.audit.agriin.Domains.DTOs.Entities.Treatment;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorResponse;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Treatment}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TreatmentResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id,
                                List<ParcelResponse> parcels, DrugResponse drug, LocalDate applicationDate,
                                LocalTime applicationStartTime, LocalTime applicationEndTime, double quantity,
                                ConcentrationUnit concentrationUnit, double bouillie, double totalQuantity,
                                double concentration, TreatmentType treatmentType,
                                DrugApplicationStage drugApplicationStage, OperatorResponse operator,
                                String observation, String materials) implements _Response {


}