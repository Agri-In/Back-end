package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.Address;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Firm extends AbstractEntity<UUID>{

    @Column(name = "firm_name", unique = true, nullable = false)
    private String name;

    @Column(name = "firm_surface_hectare")
    @Description("Firm Surface in hectares")
    private double surface;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<FirmAssignment> firmAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<Parcel> parcels = new ArrayList<>();

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<FirmAnalysis> firmAnalyses = new ArrayList<>();

    @ManyToMany(mappedBy = "firms", fetch = FetchType.LAZY)
    private List<Audit> audits = new ArrayList<>();

    @OneToOne
    private FileOwner storage;
}
