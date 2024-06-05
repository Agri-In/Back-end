package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Domains.Entities.Business.*;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper.TreatmentMapper;
import com.audit.agriin.Repositories.DrugRepository;
import com.audit.agriin.Repositories.OperatorRepository;
import com.audit.agriin.Repositories.ParcelRepository;
import com.audit.agriin.Repositories.TreatmentRepository;
import com.audit.agriin.Services.Specification.TreatmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("treatments")
public class TreatmentServiceImp extends _ServiceImp<UUID, TreatmentRequest, TreatmentResponse, Treatment, TreatmentRepository, TreatmentMapper> implements TreatmentService {

    private final ParcelRepository parcelRepository;
    private final DrugRepository drugRepository;
    private final OperatorRepository operatorRepository;

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

    @Override
    @Caching(
            evict = {
                    @CacheEvict(
                            key = "#result.get()",
                            allEntries = true,
                            condition = "#result.get() != null"
                    )
            }
    )
    @Transactional
    public Optional<TreatmentResponse> create(TreatmentRequest request) {
        Drug drug = drugRepository.findById(request.drugId()).orElseThrow(() -> new ResourceNotCreatedException("No drug found with the given id"));
        Operator operator = operatorRepository.findById(request.operatorId()).orElseThrow(() -> new ResourceNotCreatedException("No drug found with the given id"));
        List<Parcel> parcels = parcelRepository.findAllById(request.parcelIds());
        Treatment treatment = mapper.toEntityFromRequest(request);
        treatment.setDrug(drug);
        treatment.setOperator(operator);
        treatment.setParcels(Set.copyOf(parcels));
        return Optional.ofNullable(mapper.toResponse(repository.save(treatment)));
    }
}
