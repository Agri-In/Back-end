package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.AuditStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Audit extends AbstractEntity<UUID> {

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

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
    @Column(columnDefinition = "TEXT Default 'PENDING'")
    private AuditStatus status;


}
