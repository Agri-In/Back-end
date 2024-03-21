package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ExternalConsultant.ExternalConsultantRequest;
import com.audit.agriin.Domains.DTOs.Entities.ExternalConsultant.ExternalConsultantResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.ExternalConsultant;
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
public interface ExternalConsultantMapper extends _Mapper<UUID, ExternalConsultantRequest, ExternalConsultantResponse, ExternalConsultant> {
    @Mapping(source = "consultancyFirmId", target = "consultancyFirm.id")
    ExternalConsultant toEntity(ExternalConsultantRequest externalConsultantRequest);

//    @Mapping(target = "userGroupIds", expression = "java(userGroupsToUserGroupIds(externalConsultant.getUserGroups()))")
//    @Mapping(source = "consultancyFirm.id", target = "consultancyFirmId")
//    ExternalConsultantRequest toDto(ExternalConsultant externalConsultant);

    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    default Set<String> userGroupsToUserGroupNames(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getName).collect(Collectors.toSet());
    }

    @Mapping(source = "consultancyFirmLegalName", target = "consultancyFirm.legalName")
    @Mapping(source = "consultancyFirmId", target = "consultancyFirm.id")
    ExternalConsultant toEntity(ExternalConsultantResponse externalConsultantResponse);
//
//    @InheritInverseConfiguration(name = "toEntity")
//    @Override
//    ExternalConsultantResponse toResponse(ExternalConsultant externalConsultant);
//
//    @Override
//    List<ExternalConsultantResponse> toResponse(List<ExternalConsultant> entity);
//
//    ExternalConsultantResponse toResponseFromEntity(ExternalConsultant externalConsultant);
//
//    @Override
//    List<ExternalConsultantResponse> toResponseFromEntity(List<ExternalConsultant> entity);

}
