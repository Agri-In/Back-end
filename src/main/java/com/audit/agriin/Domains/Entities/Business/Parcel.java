package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import jdk.jfr.Description;
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
public class Parcel extends AbstractEntity<UUID> {

    @Column(name = "parcel_name")
    private String name;

    @Column(name = "parcel_surface_hectare")
    @Description("Parcel Surface in hectares")
    private double surface;

    @ManyToOne
    private Culture culture;

    @ManyToOne
    private Firm firm;

    @OneToOne
    private FileOwner storage;
}
