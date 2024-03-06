package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Drug extends AbstractEntity<UUID> {

    @Column(name = "commercial_name")
    private String commercialName;

    @Column(name = "drug_description")
    private String description;

    @ManyToOne
    private ActiveMatter activeMatter;

    @Column(name = "drug_dosage")
    private String dosage;

    @OneToMany
    private Set<Enemy> enemies = new HashSet<>();

    @Column(name = "days_after_residue")
    @Description("Days After Residue")
    private int dar;

    @Column(name = "max_application")
    private int maxApplication;

    @OneToMany
    private Set<LMR> lmrs = new HashSet<>();

    @Enumerated
    private DrugType drugType;

    @Enumerated
    private DrugCharacter drugCharacter;

}
