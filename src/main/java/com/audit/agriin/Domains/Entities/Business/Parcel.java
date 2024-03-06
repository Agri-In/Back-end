package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Parcel extends AbstractEntity<UUID> {

    @Column(name = "parcel_surface_hectare")
    @Description("Parcel Surface in hectares")
    private double surface;

    @ManyToOne
    private Culture culture;

    @ManyToOne
    private Firm firm;

    @OneToMany(mappedBy = "parcel", fetch = FetchType.LAZY)
    private List<FileStorage> files;
}
