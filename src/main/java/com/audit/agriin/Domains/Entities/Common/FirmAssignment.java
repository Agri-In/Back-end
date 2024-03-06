package com.audit.agriin.Domains.Entities.Common;


import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.NonCorporate.FirmResponsible;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FirmAssignment extends AbstractEntity<UUID>{


    @ManyToOne
    private FirmResponsible firmResponsible;

    @ManyToOne
    private Firm firm;

    @Column(name = "in_duty", columnDefinition = "boolean default true")
    private boolean inDuty;
}
