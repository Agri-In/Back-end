package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ConsultancyFirm.ConsultancyFirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.ConsultancyFirm.ConsultancyFirmResponse;
import com.audit.agriin.Domains.Entities.Corporate.ConsultancyFirm;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ConsultancyFirmMapper extends _Mapper<UUID, ConsultancyFirmRequest, ConsultancyFirmResponse, ConsultancyFirm> {
    ConsultancyFirm toEntity(ConsultancyFirmRequest consultancyFirmRequest);

    ConsultancyFirmRequest toDto(ConsultancyFirm consultancyFirm);

    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    ConsultancyFirm toEntity(ConsultancyFirmResponse consultancyFirmResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Override
    ConsultancyFirmResponse toResponse(ConsultancyFirm consultancyFirm);

}
