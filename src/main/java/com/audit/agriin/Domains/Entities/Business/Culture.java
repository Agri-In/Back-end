package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Culture extends AbstractEntity<UUID> {

    @Column(name = "culture_name")
    private String name;

    @Column(name = "culture_description")
    private String description;

    @OneToOne
    private Variety variety;

    @OneToMany
    private List<Parcel> parcels = new ArrayList<>();
}
