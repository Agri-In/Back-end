package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import io.micrometer.common.lang.NonNullApi;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@NonNullApi
public interface GroupRequestRepository extends JpaRepository<GroupRequest, UUID> {
    //    @NotNull GroupRequest findGroupRequestById(UUID id);
    Optional<GroupRequest> findById(UUID id);
}
