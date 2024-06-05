package com.audit.agriin.Domains.DTOs.Entities.Drug;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.digester.annotations.rules.SetTop;

import java.util.Set;
import java.util.UUID;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor


public class DrugRequestBean {

    @CsvBindByName(column = "commercialName")
    private String commercialName;

    @CsvBindByName(column = "dosage")
    private double dosage;

//    private String description;

//    private Set<UUID> activeMatterIds;

    @CsvBindByName(column = "dosageUnit")
    private String dosageUnit;

    @CsvBindByName(column = "maxApplication")
    private Integer maxApplication;

//    private Set<LMRRequest> lmrs;

    @CsvBindByName(column = "dar")
    private Integer dar;

    @CsvBindByName(column = "drugType")
    private String drugType;

    @CsvBindByName(column = "drugCharacter")
    private String drugCharacter;
}