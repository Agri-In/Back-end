package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuditType extends AbstractEntity<UUID> {

    @Column(name = "audit_type_name", unique = true, nullable = false)
    private String name;

    @Column(name = "audit_type_description")
    private String description;

    @OneToOne
    private AuditChecklist auditChecklist;

    @OneToMany(mappedBy = "auditType")
    private List<Audit> audits;
}
