package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisResponse;
import com.audit.agriin.Domains.Entities.Business.FirmAnalysis;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FirmAnalysisMapper extends _Mapper<UUID, FirmAnalysisRequest, FirmAnalysisResponse, FirmAnalysis> {
    @Mapping(source = "firmId", target = "firm.id")
    @Mapping(source = "storageId", target = "storage.id")
    @Mapping(source = "storageVersion", target = "storage.version")
    @Mapping(source = "storageUpdatedAt", target = "storage.updatedAt")
    @Mapping(source = "storageCreatedAt", target = "storage.createdAt")
    FirmAnalysis toEntity(FirmAnalysisRequest firmAnalysisRequest);

    @AfterMapping
    default void linkFiles(@MappingTarget FirmAnalysis firmAnalysis) {
        firmAnalysis.getStorage().getFiles().forEach(file -> file.setFileOwner(firmAnalysis.getStorage()));
    }

    @InheritInverseConfiguration(name = "toEntity")
    FirmAnalysisRequest toDto(FirmAnalysis firmAnalysis);

    @Mapping(source = "firmName", target = "firm.name")
    FirmAnalysis toEntity(FirmAnalysisResponse firmAnalysisResponse);

    @Override
    @Mapping(source = "firm.name", target = "firmName")
    FirmAnalysisResponse toResponse(FirmAnalysis firmAnalysis);

}
