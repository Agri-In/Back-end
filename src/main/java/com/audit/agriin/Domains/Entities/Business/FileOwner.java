package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_owner")
public class FileOwner extends AbstractEntity<UUID> {

    @OneToOne(mappedBy = "storage")
    private Audit audit;

    @OneToOne(mappedBy = "storage")
    private Firm firm;

    @OneToOne(mappedBy = "storage")
    private Parcel parcel;

    @OneToOne(mappedBy = "storage")
    private AuditChecklist auditChecklist;

    @OneToOne(mappedBy = "storage")
    private FirmAnalysis firmAnalysis;


    @OneToMany(mappedBy = "fileOwner", fetch = FetchType.LAZY)
    private List<File> files;
}
