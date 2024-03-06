package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "files")
public class File extends AbstractEntity<UUID> {

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Column(name = "url", nullable = false, columnDefinition = "TEXT")
    @URL
    private String url;

    @OneToOne
    private FileStorage fileStorage;
}
