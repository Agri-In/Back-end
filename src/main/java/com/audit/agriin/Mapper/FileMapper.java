package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.File.FileRequest;
import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.audit.agriin.Domains.Entities.Business.File;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FileMapper extends _Mapper<UUID, FileRequest, FileResponse, File> {
//    File toEntity(FileRequest fileRequest);
//
//    @Mapping(source = "fileOwnerId", target = "fileOwner.id")
//    File toEntity(FileResponse fileResponse);

    @Override
    @Mapping(source = "fileOwner.id", target = "fileOwnerId")
    FileResponse toResponse(File file);

//    FileResponse toResponseFromEntity(File file);

}
