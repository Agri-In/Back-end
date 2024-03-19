package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Group.GroupRequest;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface GroupMapper extends _Mapper<UUID, GroupRequest, GroupResponse, Group> {
    Group toEntity(GroupRequest groupRequest);

    GroupRequest toDto(Group group);

    Group toEntity(GroupResponse groupResponse);
}
