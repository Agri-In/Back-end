package com.audit.agriin.Domains.DTOs.Entities.Parcel;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Parcel}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ParcelRequest(String name, double surface, FirmDto firm) implements _Request {
    /**
     * DTO for {@link com.audit.agriin.Domains.Entities.Business.Firm}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record FirmDto(UUID id) implements _Request {
    }
}