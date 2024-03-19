package com.audit.agriin.Domains.DTOs.Entities.Parcel;

import com.audit.agriin.Domains.DTOs.Entities.File.FileResponse;
import com.audit.agriin.Domains.DTOs.Entities.FileOwner.FileOwnerDto;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Parcel}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ParcelResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name, double surface,
                             String cultureName, String firmName, FileOwnerDto storage) implements _Response {
}