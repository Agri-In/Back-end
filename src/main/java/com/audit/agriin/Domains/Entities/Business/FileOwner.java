package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "file_owner")
public class FileOwner extends AbstractEntity<UUID> {

    @OneToOne
    private Audit audit;

    @OneToOne
    private Firm firm;

    @OneToOne
    private Parcel parcel;

    @OneToOne
    private AuditChecklist auditChecklist;

    @OneToOne
    private FirmAnalysis firmAnalysis;


    @OneToMany(mappedBy = "fileOwner", fetch = FetchType.LAZY)
    private List<File> files;
}
