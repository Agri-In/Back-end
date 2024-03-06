package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
public class AuditType extends AbstractEntity<UUID> {

    @Column(name = "audit_type_name")
    private String name;

    @Column(name = "audit_type_description")
    private String description;

    @Column(name = "audit_type_code", unique = true, nullable = false)
    private String code;
}
