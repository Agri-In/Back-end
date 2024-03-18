package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Domains.Entities.Business.LMR;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface LMRMapper extends _Mapper<UUID, LMRRequest, LMRResponse, LMR> {
    @Mapping(source = "activeMatterId", target = "activeMatter.id")
    LMR toEntity(LMRRequest LMRRequest);

    @Mapping(source = "activeMatter.id", target = "activeMatterId")
    LMRRequest toDto(LMR LMR);

    LMR toEntity(LMRResponse LMRResponse);
}
