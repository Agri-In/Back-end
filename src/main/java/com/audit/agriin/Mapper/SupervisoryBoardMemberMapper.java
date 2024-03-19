package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.SupervisoryBoardMember.SupervisoryBoardMemberRequest;
import com.audit.agriin.Domains.DTOs.Entities.SupervisoryBoardMember.SupervisoryBoardMemberResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.SupervisoryBoardMember;
import org.mapstruct.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface SupervisoryBoardMemberMapper extends _Mapper<UUID, SupervisoryBoardMemberRequest, SupervisoryBoardMemberResponse, SupervisoryBoardMember> {
    @Mapping(source = "managedCompanyId", target = "managedCompany.id")
    SupervisoryBoardMember toEntity(SupervisoryBoardMemberRequest supervisoryBoardMemberRequest);

    @Mapping(target = "userGroupIds", expression = "java(userGroupsToUserGroupIds(supervisoryBoardMember.getUserGroups()))")
    @Mapping(source = "managedCompany.id", target = "managedCompanyId")
    SupervisoryBoardMemberRequest toDto(SupervisoryBoardMember supervisoryBoardMember);

    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    @Mapping(source = "managedCompanyLegalName", target = "managedCompany.legalName")
    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    SupervisoryBoardMember toEntity(SupervisoryBoardMemberResponse supervisoryBoardMemberResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "userGroupNames", expression = "java(userGroupsToUserGroupNames(supervisoryBoardMember.getUserGroups()))")
    @Override
    SupervisoryBoardMemberResponse toResponse(SupervisoryBoardMember supervisoryBoardMember);

    default Set<String> userGroupsToUserGroupNames(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getName).collect(Collectors.toSet());
    }
}
