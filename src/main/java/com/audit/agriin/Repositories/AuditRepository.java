package com.audit.agriin.Repositories;

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
 * Repository interface for accessing and managing {@link Audit} entities in the database.
 */

@Repository
public interface AuditRepository extends JpaRepository<Audit, UUID> {

    Optional<List<Audit>> findAuditsByDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<List<Audit>> findAuditsByDate(LocalDate date);

    Optional<List<Audit>> findAuditsByAuditType(AuditType auditType);

    Optional<List<Audit>> findAuditsByStatus(AuditStatus status);

    Optional<List<Audit>> findAuditsByDateBetweenAndAuditType(LocalDate startDate, LocalDate endDate, AuditType auditType);

    Optional<List<Audit>> findAuditsByDateBetweenAndStatus(LocalDate startDate, LocalDate endDate, AuditStatus status);

    Optional<List<Audit>> findAuditsByFirmsContaining(Firm firm);
}
