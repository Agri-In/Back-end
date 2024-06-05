package com.audit.agriin.Domains.DTOs.Entities.ActiveMatter;

import com.audit.agriin.Domains.DTOs._Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveMatterResponse implements _Response {
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