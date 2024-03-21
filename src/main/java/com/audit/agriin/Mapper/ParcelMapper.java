package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ParcelMapper extends _Mapper<UUID, ParcelRequest, ParcelResponse, Parcel> {
    @Mapping(source = "firmName", target = "firm.name")
    Parcel toEntity(ParcelResponse parcelResponse);

    @AfterMapping
    default void linkFiles(@MappingTarget Parcel parcel) {
        parcel.getStorage().getFiles().forEach(file -> file.setFileOwner(parcel.getStorage()));
    }

    @Override
    @Mapping(source = "firm.name", target = "firmName")
    ParcelResponse toResponse(Parcel parcel);
//
//    @Override
//    List<ParcelResponse> toResponse(List<Parcel> entity);
//
//    ParcelResponse toResponseFromEntity(Parcel parcel);
//
//    Parcel toEntity(ParcelRequest parcelRequest);
//
//    @Override
//    List<ParcelResponse> toResponseFromEntity(List<Parcel> entity);

}
