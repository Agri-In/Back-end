package com.audit.agriin.Domains.DTOs.Entities.FileOwner;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.Entities.Business.File;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
     * DTO for {@link com.audit.agriin.Domains.Entities.Business.FileOwner}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record FileOwnerDto(List<File> files) implements _Request {
    }