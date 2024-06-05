package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.Enemy;
import org.mapstruct.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {LMRMapper.class})
public interface DrugMapper extends _Mapper<UUID, DrugRequest, DrugResponse, Drug> {
//    Drug toEntity(DrugRequest drugRequest);
//
    @AfterMapping
    default void linkLmrs(@MappingTarget Drug drug) {
        drug.getLmrs().forEach(lmr -> lmr.setDrug(drug));
    }

//    @Mapping(target = "activeMatterIds", expression = "java(activeMattersToActiveMatterIds(drug.getActiveMatters()))")
//    @Mapping(target = "enemyIds", expression = "java(enemiesToEnemyIds(drug.getEnemies()))")
//    DrugRequest toDto(Drug drug);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Drug partialUpdate(DrugRequest drugRequest, @MappingTarget Drug drug);
//
//    default Set<UUID> enemiesToEnemyIds(Set<Enemy> enemies) {
//        return enemies.stream().map(Enemy::getId).collect(Collectors.toSet());
//    }
//    @Mapping(source = "activeMatterIds", target = "activeMatters.id")
//    Drug toEntity(DrugRequest drugRequest);

//    @Mapping(source = "activeMatter.id", target = "activeMatterId")
//    DrugRequest toDto(Drug drug);

//    @Mapping(source = "activeMatterNames", target = "activeMatters.name")
//    Drug toEntity(DrugResponse drugResponse);
//
//    @AfterMapping
//    default void linkLmrs(@MappingTarget Drug drug) {
//        drug.getLmrs().forEach(lmr -> lmr.setDrug(drug));
//    }

    DrugResponse toResponse(Drug drug);
//
//
//    default Set<String> enemiesToEnemyNames(Set<Enemy> enemies) {
//        return enemies.stream().map(Enemy::getName).collect(Collectors.toSet());
//    }
}
