package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface DrugMapper extends _Mapper<UUID, DrugRequest, DrugResponse, Drug> {
    @Mapping(source = "activeMatterId", target = "activeMatter.id")
    Drug toEntity(DrugRequest drugRequest);

    @Mapping(source = "activeMatter.id", target = "activeMatterId")
    DrugRequest toDto(Drug drug);

}
