package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.AuditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ActiveMatter} entities in the database.
 */

@Repository
public interface AuditTypeRepository extends JpaRepository<AuditType, UUID> {
    Optional<AuditType> findAuditTypeByName(String name);
}
