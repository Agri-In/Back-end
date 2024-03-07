package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Domains.Entities.Business.AuditType;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Enums.AuditStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ActiveMatter} entities in the database.
 */

@Repository
public interface ActiveMatterRepository extends JpaRepository<ActiveMatter, UUID> {
}
