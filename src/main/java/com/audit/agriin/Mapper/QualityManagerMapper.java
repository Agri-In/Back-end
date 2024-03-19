package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.QualityManager.QualityManagerRequest;
import com.audit.agriin.Domains.DTOs.Entities.QualityManager.QualityManagerResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.QualityManager;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface QualityManagerMapper extends _Mapper<UUID, QualityManagerRequest, QualityManagerResponse, QualityManager> {
    @Mapping(source = "managedCompanyId", target = "managedCompany.id")
    QualityManager toEntity(QualityManagerRequest qualityManagerRequest);

    @Mapping(target = "userGroupIds", expression = "java(userGroupsToUserGroupIds(qualityManager.getUserGroups()))")
    @Mapping(source = "managedCompany.id", target = "managedCompanyId")
    QualityManagerRequest toDto(QualityManager qualityManager);

    default Set<UUID> userGroupsToUserGroupIds(Set<Group> userGroups) {
        return userGroups.stream().map(Group::getId).collect(Collectors.toSet());
    }
}
