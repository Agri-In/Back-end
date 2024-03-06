package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Description;
import lombok.*;


import java.util.UUID;

@Entity
@Getter
@Setter
public class Parcel extends AbstractEntity<UUID> {

    @Column(name = "parcel_surface_hectare")
    @Description("Parcel Surface in hectares")
    private String surface;

    @ManyToOne
    private Culture culture;
}
