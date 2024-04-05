package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Exceptions.ResourceNotFoundException;
import com.audit.agriin.Mapper.ParcelMapper;
import com.audit.agriin.Repositories.FirmRepository;
import com.audit.agriin.Repositories.ParcelRepository;
import com.audit.agriin.Services.Specification.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("parcels")
public class ParcelServiceImp extends _ServiceImp<UUID, ParcelRequest, ParcelResponse, Parcel, ParcelRepository, ParcelMapper> implements ParcelService {
    private final FirmRepository firmRepository;

    /**
     * @param name
     * @return
     */
    @Override
    public Optional<ParcelResponse> findParcelByName(String name) {
        return repository.findParcelByName(name).map(mapper::toResponse);
    }

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
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'QUALITY_MANAGER', 'ACCOUNT_MANAGER')")
    public Optional<ParcelResponse> create(ParcelRequest request) {
        Optional<Firm> firm = Optional.ofNullable(firmRepository.findById(request.firmId()).orElseThrow(() -> new ResourceNotFoundException("firm with id not found")));
        Parcel parcel = mapper.toEntityFromRequest(request);
        parcel.setFirm(firm.get());
        return Optional.of(mapper.toResponse(repository.save(parcel)));
    }
}
