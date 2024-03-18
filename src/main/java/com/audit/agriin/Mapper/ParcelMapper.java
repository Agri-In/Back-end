package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ParcelMapper extends _Mapper<UUID, ParcelRequest, ParcelResponse, Parcel> {
    Parcel toEntity(ParcelRequest parcelRequest);

    ParcelRequest toDto(Parcel parcel);

    @Mapping(source = "firmName", target = "firm.name")
    @Mapping(source = "cultureName", target = "culture.name")
    Parcel toEntity(ParcelResponse parcelResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Override
    ParcelResponse toResponse(Parcel parcel);

}
