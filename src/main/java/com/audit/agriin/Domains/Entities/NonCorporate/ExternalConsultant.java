package com.audit.agriin.Domains.Entities.NonCorporate;

import com.audit.agriin.Domains.Entities.Corporate.ConsultancyFirm;
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
@Table(name = "external_consultant")
@PrimaryKeyJoinColumn(name = "userId")
public class ExternalConsultant extends User{

    @ManyToOne
    private ConsultancyFirm consultancyFirm;
}
