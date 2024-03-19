package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Image.ImageRequest;
import com.audit.agriin.Domains.DTOs.Entities.Image.ImageResponse;
import com.audit.agriin.Domains.Entities.Common.Image;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ImageMapper extends _Mapper<UUID, ImageRequest, ImageResponse, Image> {
    @Mapping(source = "storageId", target = "storage.id")
    Image toEntity(ImageRequest imageRequest);

    @Mapping(source = "storage.id", target = "storageId")
    ImageRequest toDto(Image image);

}
