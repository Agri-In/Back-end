package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyResponse;
import com.audit.agriin.Domains.Entities.Business.Enemy;
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
public interface EnemyMapper extends _Mapper<UUID, EnemyRequest, EnemyResponse, Enemy>{
}
