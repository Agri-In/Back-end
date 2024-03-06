package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "file_storage")
public class FileStorage extends AbstractEntity<UUID> {

    @ManyToOne(optional = true)
    private Audit audit;

    @ManyToOne(optional = true)
    private Firm firm;

    @ManyToOne(optional = true)
    private Parcel parcel;

    @OneToOne
    private File file;
}
