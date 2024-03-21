package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.FirmResponsible.FirmResponsibleRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmResponsible.FirmResponsibleResponse;
import com.audit.agriin.Domains.Entities.NonCorporate.FirmResponsible;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface FirmResponsibleMapper extends _Mapper<UUID, FirmResponsibleRequest, FirmResponsibleResponse, FirmResponsible> {

    List<FirmResponsibleResponse> toResponse(List<FirmResponsible> firmResponsibleList);
}
