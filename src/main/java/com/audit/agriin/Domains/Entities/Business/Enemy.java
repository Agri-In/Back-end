package com.audit.agriin.Domains.Entities.Business;


import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Enemy extends AbstractEntity<UUID> {

    @Column(name = "enemy_name")
    private String name;

    @ManyToOne
    private Drug drug;
}
