package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DrugRepository extends JpaRepository<Drug, UUID> {

    Optional<Drug> findByCommercialName(String commercialName);
}
