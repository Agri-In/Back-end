package com.audit.agriin.Domains.Entities.NonCorporate;


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
@Table(name = "quality_manager")
@PrimaryKeyJoinColumn(name = "userId")
public class QualityManager extends User{

    @OneToMany(mappedBy = "qualityManager")
    private List<AccountManager> accountManagers = new ArrayList<>();

    @ManyToOne
    private ManagedCompany managedCompany;
}
