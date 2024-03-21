package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisResponse;
import com.audit.agriin.Domains.Entities.Business.FirmAnalysis;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {FirmAssignment.class, FirmAnalysis.class}
)
public interface FirmAnalysisMapper extends _Mapper<UUID, FirmAnalysisRequest, FirmAnalysisResponse, FirmAnalysis> {


    @Mapping(source = "firmId", target = "firm.id")
    @Mapping(source = "storageId", target = "storage.id")
    FirmAnalysis toEntityFromRequest(FirmAnalysisRequest firmAnalysisRequest);

    @AfterMapping
    default void linkFiles(@MappingTarget FirmAnalysis firmAnalysis) {
        firmAnalysis.getStorage().getFiles().forEach(file -> file.setFileOwner(firmAnalysis.getStorage()));
    }

    @Mapping(source = "firmName", target = "firm.name")
    FirmAnalysis toEntityFromResponse(FirmAnalysisResponse firmAnalysisResponse);

    @Override
    @Mapping(source = "firm.name", target = "firmName")
    FirmAnalysisResponse toResponse(FirmAnalysis firmAnalysis);

//    @Override
//    List<FirmAnalysisResponse> toResponse(List<FirmAnalysis> entity);
//
//    @Override
//    List<FirmAnalysisResponse> toResponseFromEntity(List<FirmAnalysis> entity);
}
