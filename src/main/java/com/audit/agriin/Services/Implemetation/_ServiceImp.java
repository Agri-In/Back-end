package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.App.RestPage;
import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.Operator;
import com.audit.agriin.Domains.Entities.Common._Entity;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper._Mapper;
import com.audit.agriin.Services.Specification._Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Generic service implementation with common CRUD operations.
 *
 * @param <Req>        The request DTO type.
 * @param <Res>        The response DTO type.
 * @param <Entity>     The entity type.
 * @param <Repository> The repository type extending JpaRepository<Entity, UUID>.
 * @param <Mapper>     The mapper type implementing _Mapper<Req, Res, Entity>.
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 */
@Slf4j
@Validated
@AllArgsConstructor
@NoArgsConstructor(force = true)
@CacheConfig(cacheNames = "EntityCache", keyGenerator = "customKeyGenerator")
public abstract class _ServiceImp<ID, Req extends _Request, Res extends _Response, Entity extends _Entity<ID>, Repository extends JpaRepository<Entity, ID>, Mapper extends _Mapper<ID, Req, Res, Entity>> implements _Service<Req, Res, ID> {

    Mapper mapper;
    Repository repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public final void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public final void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Retrieves a list of all entities.
     *
     * @return List of response DTOs representing all entities.
     */
    @Transactional
    @Cacheable(sync = true)
    public List<Res> getAll() {
        assert repository != null;
        assert mapper != null;
        return mapper.toResponse(
                repository.findAll()
        );
    }

    /**
     * Retrieves all entities in a paginated form.
     *
     * @param pageable Pagination information.
     * @return Page of response DTOs.
     */
    @Cacheable(
            sync = true,
            condition = "#pageable != null && #pageable.pageNumber >= 0 && #pageable.pageSize > 0",
            key = "#pageable.pageNumber + ' : ' + #pageable.pageSize + ' : ' + #pageable.sort"
    )
    @Transactional
    public RestPage<Res> getAll(Pageable pageable) {
        assert repository != null;
        assert mapper != null;
        return new RestPage<>(
                repository.findAll(pageable)
                        .map(mapper::toResponse)
        );
    }

    /**
     * Creates a new entity based on the provided request DTO.
     *
     * @param request DTO containing data for entity creation.
     * @return Optional containing the response DTO of the created entity.
     */
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
    public Optional<Res> create(@Valid Req request) {
        assert mapper != null;
        assert repository != null;
        Entity entityToCreate = mapper.toEntityFromRequest(request);

        if (entityToCreate.getId() != null && repository.existsById(entityToCreate.getId()))
            throw new ResourceNotCreatedException("Entity already exists");

        try {
            Entity createdEntity = repository.saveAndFlush(entityToCreate);
            return Optional.of(mapper.toResponse(createdEntity));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Updates an existing entity based on the provided response DTO.
     *
     * @param response DTO containing updated data.
     * @return Optional containing the response DTO of the updated entity.
     */
    @CachePut(
            key = "#response"
    )
    @Transactional
    public Optional<Res> update(@Valid Res response) {
        assert mapper != null;
        assert repository != null;
        Entity entityToUpdate = mapper.toEntityFromResponse(response);

        if (entityToUpdate.getId() == null)
            throw new ResourceNotCreatedException("The given id must not be null");

        if (!repository.existsById(entityToUpdate.getId()))
            throw new ResourceNotCreatedException("Entity does not exist");

        try {
            Entity updatedEntity = repository.saveAndFlush(entityToUpdate);
            return Optional.of(mapper.toResponse(updatedEntity));
        } catch (Exception e) {
            log.error("Error while updating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id Unique identifier of the entity.
     * @return Optional containing the response DTO of the found entity.
     */
    @Transactional
    @Cacheable(
            key = "#id",
            sync = true
    )
    public Optional<Res> getById(ID id) {
        assert repository != null;
        assert mapper != null;
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    /**
     * Deletes an entity based on the provided response DTO.
     *
     * @param response DTO containing data for entity deletion.
     * @return Boolean indicating the success of the deletion operation.
     */
    @Transactional
    @CacheEvict(
            key = "#response.id",
            allEntries = true
    )
    public Boolean delete(@Valid Res response) {
        assert mapper != null;
        assert repository != null;
        Entity entityToDelete = mapper.toEntityFromResponse(response);

        if (entityToDelete.getId() == null)
            throw new ResourceNotCreatedException("The given id must not be null");

        if (!repository.existsById(entityToDelete.getId()))
            throw new ResourceNotCreatedException("Entity does not exist");

        try {
            repository.delete(entityToDelete);
        } catch (Exception e) {
            log.error("Error while deleting entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }

        return true;
    }
}