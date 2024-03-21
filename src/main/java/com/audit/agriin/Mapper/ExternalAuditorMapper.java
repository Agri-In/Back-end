package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ExternalAuditor.ExternalAuditorRequest;
import com.audit.agriin.Domains.DTOs.Entities.ExternalAuditor.ExternalAuditorResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.ExternalAuditor;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ExternalAuditorMapper extends _Mapper<UUID, ExternalAuditorRequest, ExternalAuditorResponse, ExternalAuditor> {
    @Mapping(source = "auditFirmId", target = "auditFirm.id")
    ExternalAuditor toEntity(ExternalAuditorRequest externalAuditorRequest);


    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    default Set<String> userGroupsToUserGroupNames(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getName).collect(Collectors.toSet());
    }

    @Mapping(source = "storageId", target = "storage.id")
    ExternalAuditor toEntity(ExternalAuditorResponse externalAuditorResponse);

    @Override
    @Mapping(source = "storage.id", target = "storageId")
    ExternalAuditorResponse toResponse(ExternalAuditor externalAuditor);

}
