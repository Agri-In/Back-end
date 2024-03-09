package com.audit.agriin.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.audit.agriin.Domains.Entities.Common.ImageStorage;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ImageStorage} entities in the database.
 */

@Repository
public interface ImageStorageRepository extends JpaRepository<ImageStorage, UUID> {

}
