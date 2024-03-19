package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Corporate.Corporation;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.audit.agriin.Domains.Entities.Common.ImageStorage;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ImageStorage} entities in the database.
 */

@Repository
public interface ImageStorageRepository extends JpaRepository<ImageStorage, UUID> {

    ImageStorage findImageStorageByCorporation(Corporation corporation);
    ImageStorage findImageStorageByUser(User user);

}
