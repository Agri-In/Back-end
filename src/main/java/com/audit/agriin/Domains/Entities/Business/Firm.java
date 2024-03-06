package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
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
public class Firm extends AbstractEntity<UUID> {

    @Column(name = "firm_name")
    private String name;

    @Column(name = "firm_surface_hectare")
    @Description("Firm Surface in hectares")
    private String surface;

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<FirmAssignment> firmAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<Parcel> parcels = new ArrayList<>();

    @ManyToOne
    private Audit audit;

    @OneToMany(mappedBy = "firm", fetch = FetchType.LAZY)
    private List<FileStorage> fileStorages;
}
