package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistResponse;
import com.audit.agriin.Domains.Entities.Business.AuditChecklist;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AuditChecklistMapper extends _Mapper<UUID, AuditChecklistRequest, AuditChecklistResponse, AuditChecklist> {

    @Mapping(source = "auditTypeId", target = "auditType.id")
    AuditChecklist toEntity(AuditChecklistRequest auditChecklistRequest);

    @AfterMapping
    default void linkFiles(@MappingTarget AuditChecklist auditChecklist) {
        auditChecklist.getStorage().getFiles().forEach(file -> file.setFileOwner(auditChecklist.getStorage()));
    }

    @Mapping(source = "auditTypeName", target = "auditType.name")
    AuditChecklist toEntity(AuditChecklistResponse auditChecklistResponse);

    @Override
    @Mapping(source = "auditType.name", target = "auditTypeName")
    AuditChecklistResponse toResponse(AuditChecklist auditChecklist);

//    @Override
//    List<AuditChecklistResponse> toResponse(List<AuditChecklist> entity);
//
//    @Override
//    List<AuditChecklistResponse> toResponseFromEntity(List<AuditChecklist> entity);
}
