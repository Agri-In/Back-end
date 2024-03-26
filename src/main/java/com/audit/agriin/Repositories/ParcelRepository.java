package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Culture;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
    Optional<Parcel> findParcelByName(String name);
    Optional<Parcel> findParcelsByCulture(Culture culture);
}
