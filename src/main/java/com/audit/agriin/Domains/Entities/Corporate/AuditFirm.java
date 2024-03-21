package com.audit.agriin.Domains.Entities.Corporate;

import com.audit.agriin.Domains.Entities.NonCorporate.ExternalAuditor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "audit_firm")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "corporationId")
@NoArgsConstructor
@AllArgsConstructor
public class AuditFirm extends Corporation {

    @OneToMany(mappedBy = "auditFirm", fetch = FetchType.LAZY)
    private List<ExternalAuditor> externalAuditors = new ArrayList<>();

    @ManyToMany(mappedBy = "consultancyFirms")
    private Set<ManagedCompany> users = new HashSet<>();
}