package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Mapper.FirmMapper;
import com.audit.agriin.Repositories.FirmRepository;
import com.audit.agriin.Services.Specification.FirmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FirmServiceImp extends _ServiceImp<UUID, FirmRequest, FirmResponse, Firm, FirmRepository, FirmMapper> implements FirmService {
    /**
     * @param name
     * @return
     */
    @Override
    public Optional<FirmResponse> findFirmByName(String name) {
        return repository.findFirmByName(name).map(mapper::toResponse);
    }
}
