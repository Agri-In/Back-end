package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ExternalAuditor.ExternalAuditorRequest;
import com.audit.agriin.Domains.DTOs.Entities.ExternalAuditor.ExternalAuditorResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.ExternalAuditor;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import org.mapstruct.*;

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

    @Mapping(target = "userGroupIds", expression = "java(userGroupsToUserGroupIds(externalAuditor.getUserGroups()))")
    @Mapping(source = "auditFirm.id", target = "auditFirmId")
    ExternalAuditorRequest toDto(ExternalAuditor externalAuditor);

    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    @Mapping(source = "auditFirmLegalName", target = "auditFirm.legalName")
    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    ExternalAuditor toEntity(ExternalAuditorResponse externalAuditorResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "userGroupNames", expression = "java(userGroupsToUserGroupNames(externalAuditor.getUserGroups()))")
    @Override
    ExternalAuditorResponse toResponse(ExternalAuditor externalAuditor);

    default Set<String> userGroupsToUserGroupNames(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getName).collect(Collectors.toSet());
    }
}
