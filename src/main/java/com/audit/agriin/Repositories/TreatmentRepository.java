package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.Operator;
import com.audit.agriin.Domains.Entities.Business.Treatment;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, UUID>{
    Optional<List<Treatment>> findTreatmentsByApplicationDate(LocalDate applicationDate);
    Optional<List<Treatment>> findTreatmentsByApplicationDateBetween(LocalDate startDate, LocalDate endDate);
    Optional<List<Treatment>> findTreatmentsByDrug(Drug drug);
    Optional<List<Treatment>> findTreatmentsByDrugApplicationStage(DrugApplicationStage drugApplicationStage);
    Optional<List<Treatment>> findTreatmentsByOperator(Operator operator);
}
