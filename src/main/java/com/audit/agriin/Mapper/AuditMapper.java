package com.audit.agriin.Mapper;


import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import org.mapstruct.*;
import com.audit.agriin.Domains.Entities.Business.Audit;

import java.util.List;
import java.util.UUID;

/**
 * Mapper interface for converting between {@link Audit} DTOs and entities.
 * Uses MapStruct for automatic mapping implementation.
 */


@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuditMapper extends _Mapper<UUID, AuditRequest, AuditResponse, Audit> {


    Audit toEntity(AuditResponse auditResponse);

    @AfterMapping
    default void linkFiles(@MappingTarget Audit audit) {
        audit.getStorage().getFiles().forEach(file -> file.setFileOwner(audit.getStorage()));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Audit partialUpdate(AuditResponse auditResponse, @MappingTarget Audit audit);

    @Override
    @Mapping(source = "auditType.name", target = "auditType.name")
    AuditResponse toResponse(Audit audit);

//    AuditResponse toResponseFromEntity(Audit audit);

//    Audit toEntity(AuditRequest auditRequest);

//    List<Audit> toEntity(List<AuditRequest> entity);
//
//    @Override
//    List<AuditResponse> toResponse(List<Audit> entity);
//
//    List<Audit> toEntityFromResponse(List<AuditResponse> entity);

//    @Override
//    Audit toEntityFromResponse(AuditResponse auditResponse);
}