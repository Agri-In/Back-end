package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Group.GroupRequest;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;

import java.util.Optional;
import java.util.UUID;

public interface GroupService extends _Service<GroupRequest, GroupResponse, UUID>{

    Optional<GroupResponse> findGroupByCode(String code);
    Optional<GroupResponse> findGroupByName(String name);

}
