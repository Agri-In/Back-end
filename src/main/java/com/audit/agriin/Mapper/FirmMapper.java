package com.audit.agriin.Mapper;


import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
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

//    FirmRequest toDto(Firm firm);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Firm partialUpdate(FirmRequest firmRequest, @MappingTarget Firm firm);


    @AfterMapping
    default void linkFirmAssignments(@MappingTarget Firm firm) {
        firm.getFirmAssignments().forEach(firmAssignment -> firmAssignment.setFirm(firm));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Firm partialUpdate(FirmResponse firmResponse, @MappingTarget Firm firm);

    default List<String> parcelsToParcelNames(List<Parcel> parcels) {
        return parcels.stream().map(Parcel::getName).collect(Collectors.toList());
    }
    @AfterMapping
    default void linkParcels(@MappingTarget Firm firm) {
        firm.getParcels().forEach(parcel -> parcel.setFirm(firm));
    }

    @AfterMapping
    default void linkFirmAnalyses(@MappingTarget Firm firm) {
        firm.getFirmAnalyses().forEach(firmAnalysis -> firmAnalysis.setFirm(firm));
    }

    @AfterMapping
    default void linkFiles(@MappingTarget Firm firm) {
        firm.getStorage().getFiles().forEach(file -> file.setFileOwner(firm.getStorage()));
    }

    default List<Boolean> firmAssignmentsToFirmAssignmentInDuties(List<FirmAssignment> firmAssignments) {
        return firmAssignments.stream().map(FirmAssignment::isInDuty).collect(Collectors.toList());
    }

    Firm toEntity(FirmResponse firmResponse);

    @Override
    FirmResponse toResponse(Firm firm);

    @Override
    List<FirmResponse> toResponse(List<Firm> entity);
}