package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorRequest;
import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorResponse;
import com.audit.agriin.Domains.Entities.Business.Operator;

import java.util.Optional;
import java.util.UUID;

public interface OperatorService extends _Service<OperatorRequest, OperatorResponse, UUID>{

    Optional<Operator> getOperatorById(UUID id);
}
