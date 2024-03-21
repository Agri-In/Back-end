package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Variety.VarietyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Variety.VarietyResponse;
import com.audit.agriin.Domains.Entities.Business.Variety;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface VarietyMapper extends _Mapper<UUID, VarietyRequest, VarietyResponse, Variety> {
    @Mapping(source = "cultureId", target = "culture.id")
    Variety toEntity(VarietyRequest varietyRequest);

    @Mapping(target = "culture.name")
    Variety toEntity(VarietyResponse varietyResponse);

    @Override
    @Mapping(source = "culture.name", target = "name")
    VarietyResponse toResponse(Variety variety);

//    VarietyResponse toResponseFromEntity(Variety variety);
//
//    @Override
//    Variety toEntityFromResponse(VarietyResponse varietyResponse);
//
//    @Override
//    List<VarietyResponse> toResponse(List<Variety> entity);
//
//    List<Variety> toEntity(List<VarietyRequest> entity);

}
