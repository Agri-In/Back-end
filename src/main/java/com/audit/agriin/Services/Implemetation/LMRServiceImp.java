package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Entities.Business.LMR;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper.LMRMapper;
import com.audit.agriin.Repositories.DrugRepository;
import com.audit.agriin.Repositories.LmrRepository;
import com.audit.agriin.Services.Specification.LMRService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("lmrs")
public class LMRServiceImp extends _ServiceImp<UUID, LMRRequest, LMRResponse, LMR, LmrRepository, LMRMapper> implements LMRService {

    private final DrugRepository drugRepository;

    @Override
    @Caching(
            evict = {
                    @CacheEvict(
                            key = "#result.get()",
                            allEntries = true,
                            condition = "#result.get() != null"
                    )
            }
    )
    @Transactional
    public Optional<LMRResponse> create(LMRRequest request) {
        Drug drug = drugRepository.findById(request.drugId()).orElseThrow(() -> new ResourceNotCreatedException("No drug found with the given id"));
        LMR entityToCreate = mapper.toEntityFromRequest(request);
        entityToCreate.setDrug(drug);
        LMR createdEntity = repository.save(entityToCreate);
        return Optional.ofNullable(mapper.toResponse(createdEntity));
    }
}
