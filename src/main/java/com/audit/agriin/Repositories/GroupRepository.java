package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    Group findGroupByName(String name);
    @NotNull
    Optional<Group> findById(@NotNull UUID id);
    Optional<Group> findGroupByCode(String code);
}