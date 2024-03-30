package com.audit.agriin.Domains.DTOs.Entities.ActiveMatter;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
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
public class ActiveMatterResponse extends AbstractResponse<UUID>{
    Timestamp createdAt;
    Timestamp updatedAt;
    Long version;
    UUID id;
    String name;
    List<DrugDto> drugs;

    /**
         * DTO for {@link com.audit.agriin.Domains.Entities.Business.Drug}
         */

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record DrugDto(UUID id, String commercialName) implements _Response {
    }
}