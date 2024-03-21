package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureRequest;
import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureResponse;
import com.audit.agriin.Domains.Entities.Business.Culture;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CultureMapper extends _Mapper<UUID, CultureRequest, CultureResponse, Culture> {
    Culture toEntity(CultureResponse cultureResponse);

    @AfterMapping
    default void linkParcels(@MappingTarget Culture culture) {
        culture.getParcels().forEach(parcel -> parcel.setCulture(culture));
    }
    @Mapping(source = "varietyId", target = "variety.id")
    Culture toEntity(CultureRequest cultureRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "varietyId", target = "variety.id")
    Culture partialUpdate(CultureRequest cultureRequest, @MappingTarget Culture culture);

    @Override
    CultureResponse toResponse(Culture culture);

//    @Override
//    List<CultureResponse> toResponse(List<Culture> entity);
}
