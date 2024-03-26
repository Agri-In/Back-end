package com.audit.agriin.Services.Specification;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;

import java.util.Optional;
import java.util.UUID;

public interface ParcelService extends _Service<ParcelRequest, ParcelResponse, UUID>{

    Optional<ParcelResponse> findParcelByName(String name);
}
