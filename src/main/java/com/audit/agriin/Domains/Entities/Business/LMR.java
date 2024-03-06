package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.AuditableEntity;
import com.audit.agriin.Domains.Enums.Region;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
public class LMR extends AbstractEntity<UUID> {


    @Enumerated
    private Region region;

    @Column(name = "lmr_name_mg/kg")
    private String residue_mg_kg;

    @Embedded
    private ActiveMatter activeMatter;

    @ManyToOne
    private Drug drug;

}
