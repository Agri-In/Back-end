package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;

import java.util.Optional;
import java.util.UUID;

public interface FirmService extends _Service<FirmRequest, FirmResponse, UUID>{
    Optional<FirmResponse> findFirmByName(String name);
}
