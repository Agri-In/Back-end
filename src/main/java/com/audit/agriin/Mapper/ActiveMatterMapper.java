package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterRequest;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
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
public interface ActiveMatterMapper extends _Mapper<UUID, ActiveMatterRequest, ActiveMatterResponse, ActiveMatter> {
    ActiveMatter toEntity(ActiveMatterRequest activeMatterRequest);

    ActiveMatterRequest toDto(ActiveMatter activeMatter);

    ActiveMatter toEntity(ActiveMatterResponse activeMatterResponse);
}
