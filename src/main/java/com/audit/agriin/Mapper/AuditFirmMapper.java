package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AuditFirm.AuditFirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditFirm.AuditFirmResponse;
import com.audit.agriin.Domains.Entities.Corporate.AuditFirm;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AuditFirmMapper extends _Mapper<UUID, AuditFirmRequest, AuditFirmResponse, AuditFirm> {
    AuditFirm toEntity(AuditFirmRequest auditFirmRequest);

    AuditFirmRequest toDto(AuditFirm auditFirm);

    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    AuditFirm toEntity(AuditFirmResponse auditFirmResponse);

    @AfterMapping
    default void linkImages(@MappingTarget AuditFirm auditFirm) {
        auditFirm.getStorage().getImages().forEach(image -> image.setStorage(auditFirm.getStorage()));
    }

    @InheritInverseConfiguration(name = "toEntity")
    @Override
    AuditFirmResponse toResponse(AuditFirm auditFirm);

}
