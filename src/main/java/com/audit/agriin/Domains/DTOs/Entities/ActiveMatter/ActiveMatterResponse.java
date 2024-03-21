package com.audit.agriin.Domains.DTOs.Entities.ActiveMatter;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.ActiveMatter}
 */
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveMatterResponse extends AbstractResponse<UUID> {
    String name;
    List<String> drugCommercialNames;
}