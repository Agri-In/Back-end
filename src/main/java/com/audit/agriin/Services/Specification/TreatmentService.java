package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.Operator;
import com.audit.agriin.Domains.Entities.Business.Treatment;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TreatmentService extends _Service<TreatmentRequest, TreatmentResponse, UUID>{

    Optional<List<TreatmentResponse>> findTreatmentsByApplicationDate(LocalDate applicationDate);
    Optional<List<TreatmentResponse>> findTreatmentsByApplicationDateBetween(LocalDate startDate, LocalDate endDate);
    Optional<List<TreatmentResponse>> findTreatmentsByDrug(Drug drug);
    Optional<List<TreatmentResponse>> findTreatmentsByDrugApplicationStage(DrugApplicationStage drugApplicationStage);
    Optional<List<TreatmentResponse>> findTreatmentsByOperator(Operator operator);
}
