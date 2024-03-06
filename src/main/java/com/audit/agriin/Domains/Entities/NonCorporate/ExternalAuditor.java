package com.audit.agriin.Domains.Entities.NonCorporate;

import com.audit.agriin.Domains.Entities.Corporate.AuditFirm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "external_auditor")
@PrimaryKeyJoinColumn(name = "userId")
public class ExternalAuditor extends User{

    @ManyToOne
    @JoinColumn(name = "audit_firm_id")
    private AuditFirm auditFirm;
}
