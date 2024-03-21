package com.audit.agriin.Domains.DTOs.Entities.File;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.File}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileResponse extends AbstractResponse<UUID> {
    String name;
    String type;
    @URL
    String url;
    UUID fileOwnerId;
}