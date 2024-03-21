package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.AuditableEntity;
import com.audit.agriin.Domains.Enums.Region;
import jakarta.persistence.*;
import lombok.*;

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
public class LMR extends AbstractEntity<UUID> {


    @Enumerated
    private Region region;

    @Column(name = "lmr_name_mg/kg")
    private String residue_mg_kg;

    @OneToOne
    private ActiveMatter activeMatter;

    @ManyToOne
    private Drug drug;

}
