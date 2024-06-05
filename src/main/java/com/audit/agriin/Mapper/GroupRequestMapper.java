package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestReq;
import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestRes;
import com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest;
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
public interface GroupRequestMapper extends _Mapper<UUID, GroupRequestReq, GroupRequestRes, GroupRequest>{
}
