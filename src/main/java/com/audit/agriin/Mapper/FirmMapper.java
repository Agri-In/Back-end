package com.audit.agriin.Mapper;


import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Mapper interface for converting between {@link Audit} DTOs and entities.
 * Uses MapStruct for automatic mapping implementation.
 */


@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FirmMapper extends _Mapper<UUID, FirmRequest, FirmResponse, Firm> {
    Firm toEntity(FirmRequest firmRequest);

    FirmRequest toDto(Firm firm);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Firm partialUpdate(FirmRequest firmRequest, @MappingTarget Firm firm);

    Firm toEntity(FirmResponse firmResponse);

    @AfterMapping
    default void linkFirmAssignments(@MappingTarget Firm firm) {
        firm.getFirmAssignments().forEach(firmAssignment -> firmAssignment.setFirm(firm));
    }

    @Mapping(target = "parcelNames", expression = "java(parcelsToParcelNames(firm.getParcels()))")
    FirmResponse toDto1(Firm firm);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Firm partialUpdate(FirmResponse firmResponse, @MappingTarget Firm firm);

    default List<String> parcelsToParcelNames(List<Parcel> parcels) {
        return parcels.stream().map(Parcel::getName).collect(Collectors.toList());
    }
}