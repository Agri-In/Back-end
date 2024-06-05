package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ActiveMatter} entities in the database.
 */

@Repository
public interface ActiveMatterRepository extends JpaRepository<ActiveMatter, UUID> {

}
