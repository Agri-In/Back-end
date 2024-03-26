package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;

import java.util.Optional;
import java.util.UUID;

public interface DrugService extends _Service<DrugRequest, DrugResponse, UUID>{

    Optional<DrugResponse> findDrugByCommercialName(String commercialName);
}
