package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AccountManager.AccountManagerRequest;
import com.audit.agriin.Domains.DTOs.Entities.AccountManager.AccountManagerResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.AccountManager;
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
public interface AccountManagerMapper extends _Mapper<UUID, AccountManagerRequest, AccountManagerResponse, AccountManager> {
    @Mapping(source = "managedCompanyId", target = "managedCompany.id")
    @Mapping(source = "qualityManagerId", target = "qualityManager.id")
    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    AccountManager toEntity(AccountManagerRequest accountManagerRequest);

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "userGroupIds", expression = "java(userGroupsToUserGroupIds(accountManager.getUserGroups()))")
    AccountManagerRequest toDto(AccountManager accountManager);

    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    @Mapping(source = "managedCompanyLegalName", target = "managedCompany.legalName")
    @Mapping(source = "qualityManagerLastname", target = "qualityManager.lastname")
    @Mapping(source = "qualityManagerFirstname", target = "qualityManager.firstname")
    @Mapping(source = "qualityManagerEmail", target = "qualityManager.email")
    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    AccountManager toEntity(AccountManagerResponse accountManagerResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Override
    AccountManagerResponse toResponse(AccountManager accountManager);

}
