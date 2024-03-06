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
@Table(name = "supervisory_board_member")
@PrimaryKeyJoinColumn(name = "userId")
public class SupervisoryBoardMember extends User{

    @ManyToOne
    private ManagedCompany managedCompany;
}
