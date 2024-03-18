package com.audit.agriin.Domains.DTOs.Entities.Firm;

import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Firm}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FirmRequest(String name, double surface, AddressDto address) implements _Request {
}