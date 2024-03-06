package com.audit.agriin.Domains.Entities.NonCorporate;

import com.audit.agriin.Domains.Entities.Corporate.ManagedCompany;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "account_manager")
@PrimaryKeyJoinColumn(name = "userId")
public class AccountManager extends User{

    @ManyToOne
    private QualityManager qualityManager;

    @ManyToOne
    private ManagedCompany managedCompany;
}
