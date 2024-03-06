package com.audit.agriin.Domains.Entities.Common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * Abstract base class for entities in the Agri In application.
 * Provides common fields such as id, creation timestamp, and update timestamp.
 * Subclasses should use the @MappedSuperclass annotation.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 * @version 1.0
 */
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity<ID extends Serializable> extends AuditableEntity implements _Entity<ID> {

    /**
     * The unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name = "UUID"
    )
    private ID id;

}