package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Variety extends AbstractEntity<UUID> {

    @Column(name = "variety_name")
    private String name;

    @Column(name = "variety_description")
    private String description;

    @ManyToOne
    private Culture culture;
}
