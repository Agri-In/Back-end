package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistResponse;
import com.audit.agriin.Domains.Entities.Business.AuditChecklist;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuditChecklistMapper extends _Mapper<UUID, AuditChecklistRequest, AuditChecklistResponse, AuditChecklist> {
    @Mapping(source = "storage", target = "files", qualifiedByName = "toEntity")
    AuditChecklist toEntity(AuditChecklistRequest auditChecklistRequest);

    AuditChecklistRequest toDto(AuditChecklist auditChecklist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storage", target = "files", qualifiedByName = "partialUpdate")
    AuditChecklist partialUpdate(AuditChecklistRequest auditChecklistRequest, @MappingTarget AuditChecklist auditChecklist);

    @Mapping(source = "storageFiles", target = "files", qualifiedByName = "toEntity")
    AuditChecklist toEntity(AuditChecklistResponse auditChecklistResponse);

    @AfterMapping
    default void linkFiles(@MappingTarget AuditChecklist auditChecklist) {
        auditChecklist.getStorage().getFiles().forEach(file -> file.setFileOwner(auditChecklist.getStorage()));
    }

    @Mapping(source = "files", target = "storageFiles")
    AuditChecklistResponse toDto1(AuditChecklist auditChecklist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storageFiles", target = "files", qualifiedByName = "partialUpdate")
    AuditChecklist partialUpdate(AuditChecklistResponse auditChecklistResponse, @MappingTarget AuditChecklist auditChecklist);
}
