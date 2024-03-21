package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ConsultancyFirm.ConsultancyFirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.ConsultancyFirm.ConsultancyFirmResponse;
import com.audit.agriin.Domains.Entities.Corporate.ConsultancyFirm;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ConsultancyFirmMapper extends _Mapper<UUID, ConsultancyFirmRequest, ConsultancyFirmResponse, ConsultancyFirm> {
    ConsultancyFirm toEntity(ConsultancyFirmRequest consultancyFirmRequest);
//
//    ConsultancyFirmRequest toDto(ConsultancyFirm consultancyFirm);

    @Mapping(source = "storageId", target = "storage.id")
    ConsultancyFirm toEntity(ConsultancyFirmResponse consultancyFirmResponse);

    @Override
    @Mapping(source = "storage.id", target = "storageId")
    ConsultancyFirmResponse toResponse(ConsultancyFirm consultancyFirm);

//    ConsultancyFirmResponse toResponseFromEntity(ConsultancyFirm consultancyFirm);
//
//    @Override
//    List<ConsultancyFirmResponse> toResponseFromEntity(List<ConsultancyFirm> entity);
//
//    @Override
//    List<ConsultancyFirmResponse> toResponse(List<ConsultancyFirm> entity);



}
