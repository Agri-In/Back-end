package com.audit.agriin.Domains.DTOs.Entities.Audit;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditRequest(Timestamp date, UUID auditTypeId, List<UUID> firmIds) implements _Request {
}