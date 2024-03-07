package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.AuditStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.integration.annotation.Default;

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

    @OneToOne
    private AuditType auditType;

    @OneToMany(mappedBy = "audit", fetch = FetchType.LAZY)
    private List<Firm> firms = new ArrayList<>();

    @OneToOne
    private FileStorage storage;

    @Enumerated(EnumType.STRING)
    private AuditStatus status = AuditStatus.PENDING;


}
