package com.audit.agriin.Domains.DTOs.Entities.Culture;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Business.Variety;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Culture}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CultureResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name,
                              String description, Variety variety, List<ParcelResponse> parcels) implements _Response {
}