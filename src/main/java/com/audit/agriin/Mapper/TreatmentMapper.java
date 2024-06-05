package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import com.audit.agriin.Domains.Entities.Business.Treatment;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TreatmentMapper extends _Mapper<UUID, TreatmentRequest, TreatmentResponse, Treatment> {
    @Mapping(source = "operatorId", target = "operator.id")
    @Mapping(source = "drugId", target = "drug.id")
//    @Mapping(source = "parcelIds", target = "parcels.id")
    Treatment toEntity(TreatmentRequest treatmentRequest);

    default List<UUID> parcelsToParcelIds(List<Parcel> parcels) {
        return parcels.stream().map(Parcel::getId).collect(Collectors.toList());
    }

    @Mapping(source = "operatorPhone", target = "operator.phone")
    @Mapping(source = "operatorFullName", target = "operator.fullName")
    @Mapping(source = "drugCommercialName", target = "drug.commercialName")
//    @Mapping(source = "drug", target = "drug.id")
    Treatment toEntity(TreatmentResponse treatmentResponse);

    //    @InheritInverseConfiguration(name = "toEntity")
//    @Override
//    TreatmentResponse toResponse(Treatment treatment);
//
//    @Override
//    List<TreatmentResponse> toResponse(List<Treatment> entity);
//
//    @Mapping(source = "operator.id", target = "operator")
    TreatmentResponse toResponse(Treatment treatment);
//
//    @Override
//    List<TreatmentResponse> toResponseFromEntity(List<Treatment> entity);
//
    @Override
    @Mapping(source = "operatorId", target = "operator.id")
    @Mapping(source = "drugId", target = "drug.id")
    Treatment toEntityFromRequest(TreatmentRequest treatmentRequest);

}
