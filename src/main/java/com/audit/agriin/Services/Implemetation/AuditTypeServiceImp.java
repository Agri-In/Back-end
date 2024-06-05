package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Domains.Entities.Business.AuditType;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper.AuditTypeMapper;
import com.audit.agriin.Repositories.AuditTypeRepository;
import com.audit.agriin.Services.Specification.AuditTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("auditTypes")
public class AuditTypeServiceImp extends _ServiceImp<UUID, AuditTypeRequest, AuditTypeResponse, AuditType, AuditTypeRepository, AuditTypeMapper> implements AuditTypeService {

    /**
     * @param id
     * @return
     */

    @Override
    public AuditTypeResponse getAuditTypeById(UUID id) {
        try {
            assert repository != null;
            Optional<AuditType> entity = repository.findById(id);
            if (entity.isEmpty()) {
                throw new ResourceNotCreatedException("No audit type found with the given id");
            }
            return mapper.toResponse(entity.get());
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    @Override
    public Optional<AuditTypeResponse> create(AuditTypeRequest request) {

        AuditType entityToCreate = mapper.toEntityFromRequest(request);
        try {
            assert repository != null;
            AuditType createdEntity = repository.save(entityToCreate);
            return Optional.of(mapper.toResponse(createdEntity));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }
}
