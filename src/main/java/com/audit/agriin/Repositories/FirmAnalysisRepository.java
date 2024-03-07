package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Business.FirmAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FirmAnalysisRepository extends JpaRepository<FirmAnalysis, UUID> {
    Optional<List<FirmAnalysis>> findFirmAnalysesByFirm(Firm firm);
    Optional<List<FirmAnalysis>> findFirmAnalysesByFirmAndDate(Firm firm, LocalDate date);
    Optional<List<FirmAnalysis>> findFirmAnalysesByDate(LocalDate date);
}
