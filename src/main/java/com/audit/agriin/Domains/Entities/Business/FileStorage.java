package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "file_storage")
public class FileStorage extends AbstractEntity<UUID> {

    @OneToOne(optional = true)
    private Audit audit;

    @OneToOne(optional = true)
    private Firm firm;

    @OneToOne(optional = true)
    private Parcel parcel;

    @OneToOne(optional = true)
    private AuditChecklist auditChecklist;

    @OneToOne(optional = true)
    private FirmAnalysis firmAnalysis;



    @OneToMany
    private List<File> files = new ArrayList<>();
}
