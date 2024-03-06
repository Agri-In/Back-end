package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.AuditableEntity;
import com.audit.agriin.Domains.Entities.Common._Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Embeddable
public class ActiveMatter {

    @Id
    @Column(name = "active_matter_id")
    private UUID id;

    @Column(name = "active_matter_name")
    private String name;

    @OneToMany
    private List<Drug> drugs;

//    /**
//     * The timestamp indicating when the entity was created.
//     */
//    @CreationTimestamp
//    @ReadOnlyProperty
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private Timestamp createdAt;
//
//    /**
//     * The timestamp indicating when the entity was last updated.
//     */
//    @UpdateTimestamp
//    @ReadOnlyProperty
//    @LastModifiedDate
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Timestamp updatedAt;
}
