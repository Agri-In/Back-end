package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FirmRepository extends JpaRepository<Firm, UUID> {

    Optional<Firm> findFirmByName(String name);
}
