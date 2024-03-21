package com.audit.agriin.Domains.DTOs.Entities.QualityManager;

import com.audit.agriin.Domains.DTOs.Entities.AccountManager.AccountManagerResponse;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;
import com.audit.agriin.Domains.DTOs.Entities.Image.ImageResponse;
import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyResponse;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.Gender;
import com.audit.agriin.Domains.Enums.IdentityDocumentType;
import com.audit.agriin.Domains.Enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.QualityManager}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class QualityManagerResponse implements _Response {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long version;
    private UUID id;
    private List<ImageResponse> storageImages;
    @Pattern(message = "Phone number must match the format '0XXXXXXXXX'", regexp = "0\\d{9}")
    private String phoneNumber;
    @Size(message = "Email is too long", max = 80) @Email(message = "Email was not provided")
    private String email;
    @NotNull(message = "FirstName must be present") @Size(message = "Firstname cannot be empty", min = 1)
    private String firstname;
    @Size(message = "Lastname is too long", max = 30)
    private String lastname;
    private Gender gender;
    private String nationality;
    private UserStatus status;
    private Date birthDate;
    private IdentityDocumentType identityDocumentType;
    private String identityDocumentNumber;
    private String addressRegion;
    private String addressDistrict;
    private String addressCity;
    private String addressStreet;
    private Integer addressBuilding;
    private Integer addressPostalCode;
    private Set<GroupResponse> userGroups;
    private List<AccountManagerResponse> accountManagers;
    private ManagedCompanyResponse managedCompany;
}