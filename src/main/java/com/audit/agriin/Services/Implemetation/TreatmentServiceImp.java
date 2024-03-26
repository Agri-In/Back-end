package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.Operator;
import com.audit.agriin.Domains.Entities.Business.Treatment;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Mapper.TreatmentMapper;
import com.audit.agriin.Repositories.TreatmentRepository;
import com.audit.agriin.Services.Specification.TreatmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TreatmentServiceImp extends _ServiceImp<UUID, TreatmentRequest, TreatmentResponse, Treatment, TreatmentRepository, TreatmentMapper> implements TreatmentService {

    /**
     * @param applicationDate
     * @return
     */
    @Override
    public Optional<List<TreatmentResponse>> findTreatmentsByApplicationDate(LocalDate applicationDate) {
        return repository.findTreatmentsByApplicationDate(applicationDate).map(
                treatments -> mapper.toResponse(treatments));
    }

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Optional<List<TreatmentResponse>> findTreatmentsByApplicationDateBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findTreatmentsByApplicationDateBetween(startDate, endDate).map(
                treatments -> mapper.toResponse(treatments));
    }

    /**
     * @param drug
     * @return
     */
    @Override
    public Optional<List<TreatmentResponse>> findTreatmentsByDrug(Drug drug) {
        return repository.findTreatmentsByDrug(drug).map(
                treatments -> mapper.toResponse(treatments)
        );
    }

    /**
     * @param drugApplicationStage
     * @return
     */
    @Override
    public Optional<List<TreatmentResponse>> findTreatmentsByDrugApplicationStage(DrugApplicationStage drugApplicationStage) {
        return repository.findTreatmentsByDrugApplicationStage(drugApplicationStage).map(
                treatments -> mapper.toResponse(treatments)
        );
    }

    /**
     * @param operator
     * @return
     */
    @Override
    public Optional<List<TreatmentResponse>> findTreatmentsByOperator(Operator operator) {
        return repository.findTreatmentsByOperator(operator).map(
                treatments -> mapper.toResponse(treatments)
        );
    }
}
