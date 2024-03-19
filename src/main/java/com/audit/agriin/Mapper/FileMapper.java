package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.File.FileRequest;
import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.audit.agriin.Domains.Entities.Business.File;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FileMapper extends _Mapper<UUID, FileRequest, FileResponse, File> {
    File toEntity(FileRequest fileRequest);

    FileRequest toDto(File file);

    File toEntity(FileResponse fileResponse);
}
