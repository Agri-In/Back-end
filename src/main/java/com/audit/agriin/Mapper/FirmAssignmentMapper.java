package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentResponse;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FirmAssignmentMapper extends _Mapper<UUID, FirmAssignmentRequest, FirmAssignmentResponse, FirmAssignment> {
    @Mapping(source = "firmId", target = "firm.id")
    @Mapping(source = "firmResponsibleId", target = "firmResponsible.id")
    FirmAssignment toEntity(FirmAssignmentRequest firmAssignmentRequest);

//    @InheritInverseConfiguration(name = "toEntity")
//    FirmAssignmentRequest toDto(FirmAssignment firmAssignment);

//    @InheritInverseConfiguration(name = "toEntity")
//    @Override
//    FirmAssignmentResponse toResponse(FirmAssignment firmAssignment);

    @Mapping(source = "firmName", target = "firm.name")
    @Mapping(source = "firmResponsiblePhoneNumber", target = "firmResponsible.phoneNumber")
    @Mapping(source = "firmResponsibleLastname", target = "firmResponsible.lastname")
    @Mapping(source = "firmResponsibleFirstname", target = "firmResponsible.firstname")
    FirmAssignment toEntity(FirmAssignmentResponse firmAssignmentResponse);

//    FirmAssignmentResponse toResponseFromEntity(FirmAssignment firmAssignment);

//    @Override
//    List<FirmAssignmentResponse> toResponseFromEntity(List<FirmAssignment> entity);

//    @Override
//    List<FirmAssignmentResponse> toResponse(List<FirmAssignment> entity);
//
//    List<FirmAssignment> toEntity(List<FirmAssignmentRequest> entity);
}