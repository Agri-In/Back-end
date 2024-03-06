package com.audit.agriin.Domains.Entities.Corporate;

import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.Address;
import com.audit.agriin.Domains.Enums.CorporationSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
@Setter
@Entity
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_corporation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Corporation extends AbstractEntity<UUID> {

    @NotNull(message = "FirstName must be present")
    @Size(min = 1, message = "Firstname cannot be empty")
    @Size(max = 30, message = "Firstname is too long")
    private String legalName;

    @Size(min = 1, message = "Firstname cannot be empty")
    @Size(max = 30, message = "Firstname is too long")
    private String foundationDate;

    @Embedded
    private Address address = new Address();


    @Email(message = "Email was not provided")
    @Size(max = 80, message = "Email is too long")
    @Column(unique = true)
    private String email;


    @Enumerated(EnumType.STRING)
    private CorporationSize size;

    @Pattern(regexp = "0\\d{9}", message = "Phone number must match the format '0XXXXXXXXX'")
    @Column(unique = true)
    private String phoneNumber;
}
