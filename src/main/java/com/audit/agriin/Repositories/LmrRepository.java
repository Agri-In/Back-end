package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.LMR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LmrRepository extends JpaRepository<LMR, UUID> {
}
