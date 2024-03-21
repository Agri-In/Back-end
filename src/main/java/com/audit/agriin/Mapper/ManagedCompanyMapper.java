package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyRequest;
import com.audit.agriin.Domains.DTOs.Entities.ManagedCompany.ManagedCompanyResponse;
import com.audit.agriin.Domains.Entities.Corporate.ManagedCompany;
import org.mapstruct.*;

import java.util.List;
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


    @Mapping(source = "storageId", target = "storage.id")
    ManagedCompany toEntity(ManagedCompanyResponse managedCompanyResponse);

    @Override
    @Mapping(source = "storage.id", target = "storageId")
    ManagedCompanyResponse toResponse(ManagedCompany managedCompany);
//
//    @Override
//    List<ManagedCompanyResponse> toResponse(List<ManagedCompany> entity);
//
//    @Override
//    List<ManagedCompanyResponse> toResponseFromEntity(List<ManagedCompany> entity);
}
