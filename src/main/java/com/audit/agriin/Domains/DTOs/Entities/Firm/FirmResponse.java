package com.audit.agriin.Domains.DTOs.Entities.Firm;

import com.audit.agriin.Domains.DTOs.AbstractResponse;
import com.audit.agriin.Domains.DTOs.Basic.AddressDto;
import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisResponse;
import com.audit.agriin.Domains.DTOs.Entities.FirmAssignment.FirmAssignmentResponse;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.Business.Firm}
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class  FirmResponse extends AbstractResponse<UUID> {
    String name;
    double surface;
    AddressDto address;
    List<FirmAssignmentResponse> firmAssignments;
    List<ParcelResponse> parcels;
    List<FirmAnalysisResponse> firmAnalyses;
}