package com.audit.agriin.Domains.Entities.NonCorporate;


import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Common.AbstractEntity;
import com.audit.agriin.Domains.Entities.Common.FirmAssignment;
import com.audit.agriin.Domains.Entities.Common._Entity;
import com.audit.agriin.Domains.Entities.Corporate.ManagedCompany;
import com.audit.agriin.Domains.Enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "firm_responsible")
public class FirmResponsible extends AbstractEntity<UUID> {
    /**
     * The user's first name.
     */
    @NotNull(message = "FirstName must be present")
    @Size(min = 1, message = "Firstname cannot be empty")
    @Size(max = 30, message = "Firstname is too long")
    private String firstname;

    /**
     * The user's last name.
     */
    @Size(max = 30, message = "Lastname is too long")
    private String lastname;

    /**
     * The user's gender.
     */
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    /**
     * The nationality of the user.
     */
    private String nationality;

    @Pattern(regexp = "0\\d{9}", message = "Phone number must match the format '0XXXXXXXXX'")
    @Column(unique = true)
    private String phoneNumber;

    @ManyToOne
    private ManagedCompany managedCompany;

    @OneToMany(mappedBy = "firmResponsible")
    private List<FirmAssignment> firmAssignments = new ArrayList<>();

    /**
     * Gets the timestamp when the entity was created.
     *
     * @return The timestamp of creation.
     */
    @Override
    public Timestamp getCreatedAt() {
        return null;
    }

    /**
     * Gets the timestamp when the entity was last updated.
     *
     * @return The timestamp of the last update.
     */
    @Override
    public Timestamp getUpdatedAt() {
        return null;
    }

    /**
     * Gets the version of the entity for optimistic locking.
     *
     * @return The version number.
     */
    @Override
    public Long getVersion() {
        return null;
    }
}
