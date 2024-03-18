package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureRequest;
import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureResponse;
import com.audit.agriin.Domains.Entities.Business.Culture;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CultureMapper extends _Mapper<UUID, CultureRequest, CultureResponse, Culture> {
    @Mapping(source = "varietyId", target = "variety.id")
    Culture toEntity(CultureRequest cultureRequest);

    @Mapping(source = "variety.id", target = "varietyId")
    CultureRequest toDto(Culture culture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "varietyId", target = "variety.id")
    Culture partialUpdate(CultureRequest cultureRequest, @MappingTarget Culture culture);

    Culture toEntity(CultureResponse cultureResponse);

    @AfterMapping
    default void linkParcels(@MappingTarget Culture culture) {
        culture.getParcels().forEach(parcel -> parcel.setCulture(culture));
    }
}
