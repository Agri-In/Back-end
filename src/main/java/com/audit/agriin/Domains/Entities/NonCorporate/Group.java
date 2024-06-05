package com.audit.agriin.Domains.Entities.NonCorporate;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common._Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

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

    @OneToMany(mappedBy = "group")
    private Set<GroupRequest> groupRequests = new HashSet<>();

}