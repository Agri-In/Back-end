package com.audit.agriin.Domains.DTOs.Entities.Operator;

import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Operator}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OperatorResponse(Timestamp createdAt, Timestamp updatedAt, Long version, UUID id, String fullName,
                               String phone, List<TreatmentResponse> treatments) implements _Response {
}