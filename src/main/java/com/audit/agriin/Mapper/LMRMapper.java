package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Domains.Entities.Business.LMR;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface LMRMapper extends _Mapper<UUID, LMRRequest, LMRResponse, LMR> {
//    @Mapping(source = "activeMatterId", target = "activeMatter.id")
//    LMR toEntity(LMRRequest LMRRequest);


//    @Mapping(source = "activeMatterName", target = "activeMatter.name")
//    @Mapping(source = "activeMatterId", target = "activeMatter.id")
//    LMR toEntity(LMRResponse LMRResponse);

//    @InheritInverseConfiguration(name = "toEntity")
    @Override
    @Mapping(source = "drug.id", target = "drugId")
    @Mapping(source = "drug.commercialName", target = "drugName")
    LMRResponse toResponse(LMR lmr);

//    LMRResponse toResponseFromEntity(LMR LMR);

////    @Mapping()
//    List<LMRResponse> toResponseFromEntity(List<LMR> entity);

//    @Override
//    List<LMRResponse> toResponse(List<LMR> entity);

    @Override
    @Mapping(source = "drugId", target = "drug.id")
    LMR toEntityFromRequest(LMRRequest LMRRequest);

}
