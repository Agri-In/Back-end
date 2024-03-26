package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import com.audit.agriin.Mapper.ParcelMapper;
import com.audit.agriin.Repositories.ParcelRepository;
import com.audit.agriin.Services.Specification.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImp extends _ServiceImp<UUID, ParcelRequest, ParcelResponse, Parcel, ParcelRepository, ParcelMapper> implements ParcelService {

    /**
     * @param name 
     * @return
     */
    @Override
    public Optional<ParcelResponse> findParcelByName(String name) {
        return repository.findParcelByName(name).map(mapper::toResponse);
    }
}
