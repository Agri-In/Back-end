package com.audit.agriin.Domains.Entities.NonCorporate;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common._Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "principle_groups")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Group extends AbstractEntity<UUID> {

    @Column(name = "code", unique = true, nullable = false)
    private String code;
    @Column(name = "group_name")
    private String name;

    @ManyToMany(mappedBy = "userGroups")
    private Set<User> users = new HashSet<>();
}