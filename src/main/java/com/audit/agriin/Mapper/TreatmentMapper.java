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
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ParcelMapper.class})
public interface TreatmentMapper extends _Mapper<UUID, TreatmentRequest, TreatmentResponse, Treatment> {
    @Mapping(source = "operatorId", target = "operator.id")
    @Mapping(source = "drugId", target = "drug.id")
    Treatment toEntity(TreatmentRequest treatmentRequest);

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(target = "parcelIds", expression = "java(parcelsToParcelIds(treatment.getParcels()))")
    TreatmentRequest toDto(Treatment treatment);

    default List<UUID> parcelsToParcelIds(List<Parcel> parcels) {
        return parcels.stream().map(Parcel::getId).collect(Collectors.toList());
    }

    Treatment toEntity(TreatmentResponse treatmentResponse);
}
