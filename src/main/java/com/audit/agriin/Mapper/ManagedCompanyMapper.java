package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyRequest;
import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyResponse;
import com.audit.agriin.Domains.Entities.Corporate.ManagedCompany;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ManagedCompanyMapper extends _Mapper<UUID, ManagedCompanyRequest, ManagedCompanyResponse, ManagedCompany> {
    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    ManagedCompany toEntity(ManagedCompanyRequest managedCompanyRequest);

    @InheritInverseConfiguration(name = "toEntity")
    ManagedCompanyRequest toDto(ManagedCompany managedCompany);

    @Mapping(source = "addressPostalCode", target = "address.postalCode")
    @Mapping(source = "addressBuilding", target = "address.building")
    @Mapping(source = "addressStreet", target = "address.street")
    @Mapping(source = "addressCity", target = "address.city")
    @Mapping(source = "addressDistrict", target = "address.district")
    @Mapping(source = "addressRegion", target = "address.region")
    ManagedCompany toEntity(ManagedCompanyResponse managedCompanyResponse);

    @InheritInverseConfiguration(name = "toEntity")
    @Override
    ManagedCompanyResponse toResponse(ManagedCompany managedCompany);

}
