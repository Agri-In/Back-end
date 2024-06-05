package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.AuditableEntity;
import com.audit.agriin.Domains.Entities.Common._Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveMatter extends AbstractEntity<UUID>{

    @Column(name = "active_matter_name")
    private String name;

//    @ManyToOne
//    private LMR lmr;

    @ManyToMany(mappedBy = "activeMatters", fetch = FetchType.LAZY)
    private List<Drug> drugs;

}
