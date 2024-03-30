package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Mapper.DrugMapper;
import com.audit.agriin.Repositories.ActiveMatterRepository;
import com.audit.agriin.Repositories.DrugRepository;
import com.audit.agriin.Services.Specification.DrugService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class DrugServiceImp extends _ServiceImp<UUID, DrugRequest, DrugResponse, Drug, DrugRepository, DrugMapper> implements DrugService {

    private final ActiveMatterRepository activeMatterRepository;
    /**
     * @param commercialName 
     * @return
     */
    @Override
    public Optional<DrugResponse> findDrugByCommercialName(String commercialName) {
        return Optional.empty();
    }


    @Override
    public Optional<DrugResponse> create(DrugRequest request) {
        System.out.println(request.toString());
        List<ActiveMatter> activeMatters = activeMatterRepository.findAllById(request.activeMatterIds());
        Drug drug = mapper.toEntityFromRequest(request);
        drug.setActiveMatters(Set.copyOf(activeMatters));
        return Optional.of(mapper.toResponse(repository.save(drug)));
    }
}
