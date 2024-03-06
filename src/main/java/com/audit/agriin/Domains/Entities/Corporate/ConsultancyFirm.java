package com.audit.agriin.Domains.Entities.Corporate;

import com.audit.agriin.Domains.Entities.NonCorporate.ExternalConsultant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultancy_firm")
@PrimaryKeyJoinColumn(name = "corporationId")
public class ConsultancyFirm extends Corporation{


    @OneToMany(mappedBy = "consultancyFirm", fetch = FetchType.LAZY)
    private List<ExternalConsultant> externalConsultants = new ArrayList<>();

    @ManyToMany(mappedBy = "consultancyFirms")
    private Set<ManagedCompany> managedCompanies = new HashSet<>();
}
