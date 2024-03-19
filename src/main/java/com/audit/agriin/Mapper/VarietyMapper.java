package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Variety.VarietyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Variety.VarietyResponse;
import com.audit.agriin.Domains.Entities.Business.Variety;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CultureMapper.class})
public interface VarietyMapper extends _Mapper<UUID, VarietyRequest, VarietyResponse, Variety> {
    @Mapping(source = "cultureId", target = "culture.id")
    @Mapping(target = "", source = "culture", qualifiedByName = "toEntityFromRequest")
    Variety toEntity(VarietyRequest varietyRequest);

    @Mapping(source = "culture.id", target = "cultureId")
    VarietyRequest toDto(Variety variety);

    Variety toEntity(VarietyResponse varietyResponse);
}
