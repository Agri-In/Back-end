package com.audit.agriin.Mapper;


import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import com.audit.agriin.Domains.Entities.Business.Firm;
import org.mapstruct.*;
import com.audit.agriin.Domains.Entities.Business.Audit;

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
public interface AuditMapper extends _Mapper<UUID, AuditRequest, AuditResponse, Audit> {


    @Mapping(source = "auditTypeId", target = "auditType.id")
    Audit toEntity(AuditRequest auditRequest);

    @Mapping(target = "firmIds", expression = "java(firmsToFirmIds(audit.getFirms()))")
    @Mapping(source = "auditType.id", target = "auditTypeId")
    AuditRequest toDto(Audit audit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "auditTypeId", target = "auditType.id")
    Audit partialUpdate(AuditRequest auditRequest, @MappingTarget Audit audit);

    default List<UUID> firmsToFirmIds(List<Firm> firms) {
        return firms.stream().map(Firm::getId).collect(Collectors.toList());
    }

//    Audit toEntity(AuditResponse auditResponse);

    AuditResponse toDto1(Audit audit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Audit partialUpdate(AuditResponse auditResponse, @MappingTarget Audit audit);
}