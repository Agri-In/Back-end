package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AuditFirm.AuditFirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditFirm.AuditFirmResponse;
import com.audit.agriin.Domains.Entities.Corporate.AuditFirm;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AuditFirmMapper extends _Mapper<UUID, AuditFirmRequest, AuditFirmResponse, AuditFirm> {
    AuditFirm toEntity(AuditFirmRequest auditFirmRequest);

    @AfterMapping
    default void linkImages(@MappingTarget AuditFirm auditFirm) {
        auditFirm.getStorage().getImages().forEach(image -> image.setStorage(auditFirm.getStorage()));
    }

    @Mapping(source = "storageId", target = "storage.id")
    AuditFirm toEntity(AuditFirmResponse auditFirmResponse);

    @Override
    @Mapping(source = "storage.id", target = "storageId")
    AuditFirmResponse toResponse(AuditFirm auditFirm);



}
