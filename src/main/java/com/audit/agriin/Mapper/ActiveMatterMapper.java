package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterRequest;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ActiveMatterMapper extends _Mapper<UUID, ActiveMatterRequest, ActiveMatterResponse, ActiveMatter> {

    ActiveMatter toEntity(ActiveMatterRequest activeMatterRequest);

    ActiveMatterRequest toDto(ActiveMatter activeMatter);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ActiveMatter partialUpdate(ActiveMatterRequest activeMatterRequest, @MappingTarget ActiveMatter activeMatter);

    ActiveMatter toEntity(ActiveMatterResponse activeMatterResponse);

//    ActiveMatterResponse toDto1(ActiveMatter activeMatter);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ActiveMatter partialUpdate(ActiveMatterResponse activeMatterResponse, @MappingTarget ActiveMatter activeMatter);
}
