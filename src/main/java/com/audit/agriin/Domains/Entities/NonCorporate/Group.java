package com.audit.agriin.Domains.Entities.NonCorporate;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "principle_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", unique = true, nullable = false)
    private String code;
    @Column(name = "group_name")
    private String name;

    @ManyToMany(mappedBy = "userGroups")
    private Set<User> users = new HashSet<>();
}