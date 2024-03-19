package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupRepository extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group> {
    Group findGroupByName(String name);
    Group findGroupById(Long id);
    Group findGroupByCode(String code);
}