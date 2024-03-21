package com.audit.agriin.Domains.Entities.Business;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Enums.ConcentrationUnit;
import com.audit.agriin.Domains.Enums.DrugApplicationStage;
import com.audit.agriin.Domains.Enums.TreatmentType;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
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
public class Treatment extends AbstractEntity<UUID> {

    @OneToMany
    private List<Parcel> parcels = new ArrayList<>();

    @ManyToOne
    private Drug drug;

    @Column(name = "application_date")
    @Temporal(TemporalType.DATE)
    private LocalDate applicationDate;

    @Column(name = "application_start_time")
    @Temporal(TemporalType.TIME)
    private LocalTime applicationStartTime;

    @Column(name = "application_end_time")
    @Temporal(TemporalType.TIME)
    private LocalTime applicationEndTime;


    @Description("The drug quantity in Kg over a hectare")
    private double quantity;

    @Enumerated(EnumType.STRING)
    private ConcentrationUnit concentrationUnit;


    @Column(name = "bouillie")
    private double bouillie;

    @Column(name = "total_quantity")
    private double totalQuantity;

    @Column(name = "concentration")
    @Description("The concentration of the drug in the bouillie")
    private double concentration;

    @Enumerated(EnumType.STRING)
    private TreatmentType treatmentType;

    @Enumerated(EnumType.STRING)
    private DrugApplicationStage drugApplicationStage;

    @ManyToOne
    private Operator operator;

    @Column(name = "observation", columnDefinition = "TEXT")
    @Description("Observation of the treatment")
    private String observation;

    @Column(name = "materials", columnDefinition = "TEXT")
    private String materials;

    public void setQuantity(double quantity) {
            this.quantity = quantity;
            calculateBouillie();
            calculateConcentration();
    }

    @PostLoad
    @PrePersist
    private void calculateQuantity() {
        AtomicReference<Double> totalSurface = new AtomicReference<>((double) 0);
        parcels.forEach(parcel -> {
            totalSurface.updateAndGet(v -> v + parcel.getSurface());
        });
        this.quantity = this.totalQuantity / totalSurface.get();
    }

    private void calculateBouillie() {
        double dosage = drug.getDosage();
        this.bouillie = this.quantity / dosage * 100;
    }

    private void calculateConcentration(){
        this.concentration = this.quantity / this.bouillie * 100;
    }


}
