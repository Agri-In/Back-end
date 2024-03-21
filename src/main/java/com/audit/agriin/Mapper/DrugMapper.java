package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.Enemy;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface DrugMapper extends _Mapper<UUID, DrugRequest, DrugResponse, Drug> {
    @Mapping(source = "activeMatterId", target = "activeMatter.id")
    Drug toEntity(DrugRequest drugRequest);

//    @Mapping(source = "activeMatter.id", target = "activeMatterId")
//    DrugRequest toDto(Drug drug);

    @Mapping(source = "activeMatterName", target = "activeMatter.name")
    Drug toEntity(DrugResponse drugResponse);

    @AfterMapping
    default void linkLmrs(@MappingTarget Drug drug) {
        drug.getLmrs().forEach(lmr -> lmr.setDrug(drug));
    }

    @Mapping(target = "enemyNames", expression = "java(enemiesToEnemyNames(drug.getEnemies()))")
    @Override
    @Mapping(source = "activeMatter.name", target = "activeMatterName")
    DrugResponse toResponse(Drug drug);


    default Set<String> enemiesToEnemyNames(Set<Enemy> enemies) {
        return enemies.stream().map(Enemy::getName).collect(Collectors.toSet());
    }
}
