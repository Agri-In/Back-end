package com.audit.agriin.Domains.DTOs.Entities.Firm;

import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentResponse;
import com.audit.agriin.Domains.DTOs.Entities.FirmResponsible.FirmResponsibleResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Firm}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String name, double surface,
                           AddressDto address, List<FirmAssignmentResponse> firmAssignments,
                           List<String> parcelNames
) implements _Response {
}