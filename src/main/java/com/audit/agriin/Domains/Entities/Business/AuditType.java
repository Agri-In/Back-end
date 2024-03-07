package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
public class AuditType extends AbstractEntity<UUID> {

    @Column(name = "audit_type_name", unique = true, nullable = false)
    private String name;

    @Column(name = "audit_type_description")
    private String description;

    @OneToOne
    private AuditChecklist auditChecklist;
}
