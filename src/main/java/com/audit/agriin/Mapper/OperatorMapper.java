package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorRequest;
import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorResponse;
import com.audit.agriin.Domains.Entities.Business.Operator;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TreatmentMapper.class})
public interface OperatorMapper extends _Mapper<UUID, OperatorRequest, OperatorResponse, Operator> {
//    Operator toEntity(OperatorRequest operatorRequest);

    OperatorRequest toDto(Operator operator);

//    Operator toEntity(OperatorResponse operatorResponse);

    @AfterMapping
    default void linkTreatments(@MappingTarget Operator operator) {
        operator.getTreatments().forEach(treatment -> treatment.setOperator(operator));
    }
}
