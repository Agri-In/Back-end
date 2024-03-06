package com.audit.agriin.Domains.Entities.NonCorporate;


import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import com.audit.agriin.Domains.Entities.Corporate.ManagedCompany;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "firm_responsible")
@PrimaryKeyJoinColumn(name = "userId")
public class FirmResponsible extends User{

    @ManyToOne
    private ManagedCompany managedCompany;

    @OneToMany(mappedBy = "firmResponsible")
    private List<FirmAssignment> firmAssignments = new ArrayList<>();

}
