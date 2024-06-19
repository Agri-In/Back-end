package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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

    @ManyToMany(mappedBy = "activeMatters", fetch = FetchType.LAZY)
    private List<Drug> drugs;

}
