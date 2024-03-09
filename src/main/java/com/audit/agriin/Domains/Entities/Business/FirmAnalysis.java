package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class FirmAnalysis extends AbstractEntity<UUID> {

    @Column(name = "analysis_name", nullable = false)
    private String name;

    @Column(name = "analysis_description")
    private String description;

    @Column(name = "analysis_date")
    private LocalDate date;

    @OneToOne
    private FileOwner storage;

    @ManyToOne
    private Firm firm;
}
