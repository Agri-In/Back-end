package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Group.GroupRequest;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Mapper.GroupMapper;
import com.audit.agriin.Repositories.GroupRepository;
import com.audit.agriin.Services.Specification.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("groups")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class GroupServiceImp extends _ServiceImp<UUID, GroupRequest, GroupResponse, Group, GroupRepository, GroupMapper> implements GroupService {
    /**
     * @param code 
     * @return
     */
    @Override
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Optional<GroupResponse> findGroupByCode(String code) {
        return repository.findGroupByCode(code).map(mapper::toResponse);
    }

    /**
     * @param name 
     * @return
     */
    @Override
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Optional<GroupResponse> findGroupByName(String name) {
        return Optional.of(repository.findGroupByName(name)).map(mapper::toResponse);
    }
}
