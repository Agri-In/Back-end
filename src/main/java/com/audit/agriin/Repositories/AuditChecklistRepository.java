package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.AuditChecklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link AuditChecklist} entities in the database.
 */

@Repository
public interface AuditChecklistRepository extends JpaRepository<AuditChecklist, UUID> {
}
