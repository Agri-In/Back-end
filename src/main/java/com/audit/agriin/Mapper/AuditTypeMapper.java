package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Domains.Entities.Business.AuditType;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AuditTypeMapper extends _Mapper<UUID, AuditTypeRequest, AuditTypeResponse, AuditType> {
    AuditType toEntity(AuditTypeRequest auditTypeRequest);

//    AuditTypeRequest toDto(AuditType auditType);

    @AfterMapping
    default void linkAudits(@MappingTarget AuditType auditType) {
        auditType.getAudits().forEach(audit -> audit.setAuditType(auditType));
    }

    @Mapping(source = "auditChecklistChecklistName", target = "auditChecklist.checklistName")
    AuditType toEntity(AuditTypeResponse auditTypeResponse);

    @AfterMapping
    default void linkFiles(@MappingTarget AuditType auditType) {
        auditType.getAuditChecklist().getStorage().getFiles().forEach(file -> file.setFileOwner(auditType.getAuditChecklist().getStorage()));
    }

    @Override
    @Mapping(source = "auditChecklist.checklistName", target = "auditChecklistChecklistName")
    AuditTypeResponse toResponse(AuditType auditType);
//
//    @Override
//    List<AuditTypeResponse> toResponse(List<AuditType> entity);
//
//    AuditTypeResponse toResponseFromEntity(AuditType auditType);
//
//    @Override
//    List<AuditTypeResponse> toResponseFromEntity(List<AuditType> entity);
}
