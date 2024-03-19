package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.AuditStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Audit extends AbstractEntity<UUID> {

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne
    private AuditType auditType;

    @ManyToMany
    @JoinTable(name = "audit_firm",
            joinColumns = @JoinColumn(name = "audit_id"),
            inverseJoinColumns = @JoinColumn(name = "firm_id"))
    private List<Firm> firms = new ArrayList<>();

    @OneToOne
    private FileOwner storage;

    @Enumerated(EnumType.STRING)
    private AuditStatus status = AuditStatus.PENDING;


}
