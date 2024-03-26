package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Mapper.DrugMapper;
import com.audit.agriin.Repositories.DrugRepository;
import com.audit.agriin.Services.Specification.DrugService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DrugServiceImp extends _ServiceImp<UUID, DrugRequest, DrugResponse, Drug, DrugRepository, DrugMapper> implements DrugService {
    /**
     * @param commercialName 
     * @return
     */
    @Override
    public Optional<DrugResponse> findDrugByCommercialName(String commercialName) {
        return Optional.empty();
    }
}
