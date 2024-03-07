package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class AuditChecklist extends AbstractEntity<UUID>{

    private String checklistName;

    @OneToOne
    private AuditType auditType;

    @OneToOne
    private FileStorage storage;


}
