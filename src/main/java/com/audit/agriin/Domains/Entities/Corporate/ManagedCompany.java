package com.audit.agriin.Domains.Entities.Corporate;

import com.audit.agriin.Domains.Entities.NonCorporate.AccountManager;
import com.audit.agriin.Domains.Entities.NonCorporate.QualityManager;
import com.audit.agriin.Domains.Entities.NonCorporate.SupervisoryBoardMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "managed_company")
@PrimaryKeyJoinColumn(name = "corporationId")
public class ManagedCompany extends Corporation {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "managed_company_audit_firm",
            joinColumns = @JoinColumn(name = "managedCompanyId"),
            inverseJoinColumns = @JoinColumn(name = "auditFirmId")
    )
    private Set<AuditFirm> auditFirms = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "managed_company_consultancy_firm",
            joinColumns = @JoinColumn(name = "managedCompanyId"),
            inverseJoinColumns = @JoinColumn(name = "consultancyFirmId")
    )
    private Set<ConsultancyFirm> consultancyFirms = new HashSet<>();

    @OneToMany(mappedBy = "managedCompany", fetch = FetchType.LAZY)
    private Set<QualityManager> qualityManagers = new HashSet<>();

    @OneToMany(mappedBy = "managedCompany", fetch = FetchType.LAZY)
    private Set<AccountManager> accountManagers = new HashSet<>();

    @OneToMany(mappedBy = "managedCompany", fetch = FetchType.LAZY)
    private Set<SupervisoryBoardMember> supervisoryBoardMembers = new HashSet<>();
}
