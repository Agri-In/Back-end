package com.audit.agriin.Domains.DTOs.Entities.Group;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.Group}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupResponse extends AbstractResponse<UUID> {
    String code;
    String name;
    Set<String> userEmails;
}