package com.audit.agriin.Domains.Entities.Business;


import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Enemy extends AbstractEntity<UUID> {

    @Column(name = "enemy_name")
    private String name;

    @ManyToOne
    private Drug drug;
}
