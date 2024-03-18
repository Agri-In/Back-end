package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentResponse;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {FirmResponsibleMapper.class, FirmMapper.class, CultureMapper.class})
public interface FirmAssignmentMapper extends _Mapper<UUID, FirmAssignmentRequest, FirmAssignmentResponse, FirmAssignment> {
    @Mapping(source = "firmId", target = "firm.id")
    @Mapping(source = "firmResponsibleId", target = "firmResponsible.id")
    @Mapping(target = "", source = "culture", qualifiedByName = "toEntityFromRequest")
    FirmAssignment toEntity(FirmAssignmentRequest firmAssignmentRequest);

    @InheritInverseConfiguration(name = "toEntity")
    FirmAssignmentRequest toDto(FirmAssignment firmAssignment);

    @Mapping(target = "", source = "culture", qualifiedByName = "toEntityFromResponse")
    FirmAssignment toEntity(FirmAssignmentResponse firmAssignmentResponse);
}