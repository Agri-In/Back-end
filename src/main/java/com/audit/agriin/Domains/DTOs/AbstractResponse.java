package com.audit.agriin.Domains.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Base class for response DTOs representing {@link AbstractEntity}.
 * AbstractResponse includes common fields such as id, createdAt, updatedAt, and version.
 * This class is intended to be extended by specific response DTOs in the system.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 * @version 1.0
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResponse<ID> extends AuditableResponse implements _Response {

    /**
     * The unique identifier of the entity.
     */
    private ID id;

}