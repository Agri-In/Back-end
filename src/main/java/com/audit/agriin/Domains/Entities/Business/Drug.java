package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Drug extends AbstractEntity<UUID> {

    @Column(name = "commercial_name", unique = true, nullable = false)
    private String commercialName;

    @Column(name = "drug_description")
    private String description;

    @ManyToOne
    private ActiveMatter activeMatter;

    @Column(name = "drug_dosage")
    private double dosage;

    @Enumerated(EnumType.STRING)
    private DosageUnit dosageUnit;

    @OneToMany(mappedBy = "drug", fetch = FetchType.LAZY)
    private Set<Enemy> enemies = new HashSet<>();

    @Column(name = "days_after_residue")
    @Description("Days After Residue")
    private int dar;

    @Column(name = "max_application")
    private int maxApplication;

    @OneToMany(mappedBy = "drug", fetch = FetchType.LAZY)
    private Set<LMR> lmrs = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private DrugType drugType;

    @Enumerated(EnumType.STRING)
    private DrugCharacter drugCharacter;

    @OneToMany(mappedBy = "drug", fetch = FetchType.LAZY)
    private List<Treatment> treatments;


}
