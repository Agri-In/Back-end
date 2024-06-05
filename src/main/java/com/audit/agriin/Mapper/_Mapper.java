package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs._Request;
import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Entities.Common._Entity;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Generic mapper interface for converting between DTOs (Data Transfer Objects) and entities.
 *
 * @param <ID>     The type of the entity's identifier.
 * @param <Req>    The type of the request DTO.
 * @param <Res>    The type of the response DTO.
 * @param <Entity> The type of the entity.
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 */
public interface _Mapper<ID, Req extends _Request, Res extends _Response, Entity extends _Entity<ID>> {


    /**
     * Converts a request DTO to an entity.
     *
     * @param request Request DTO.
     * @return Converted entity.
     */
    Entity toEntityFromRequest(Req request);

    /**
     * Converts a response DTO to an entity.
     *
     * @param response Response DTO.
     * @return Converted entity.
     */
    Entity toEntityFromResponse(Res response);

    /**
     * Converts an entity to a response DTO.
     *
     * @param entity Entity.
     * @return Converted response DTO.
     */
    Res toResponse(Entity entity);


    List<Res> toResponse(List<Entity> entity);



    /**
     * Applies partial updates from the request DTO to the entity, ignoring null values.
     *
     * @param request Request DTO containing partial updates.
     * @param entity  Entity to be updated.
     * @return Updated entity.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Named("partialUpdate")
    Entity applyPartialUpdates(Req request, @MappingTarget Entity entity);

    /**
     * Applies partial updates from the response DTO to the entity, ignoring null values.
     *
     * @param response Response DTO containing partial updates.
     * @param entity   Entity to be updated.
     * @return Updated entity.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Named("partialUpdate")
    Entity applyPartialUpdates(Res response, @MappingTarget Entity entity);

    /**
     * Maps a string representing the creation timestamp to a {@link Timestamp} object.
     *
     * @param createdAt String representation of the creation timestamp.
     * @return {@link Timestamp} object representing the creation timestamp.
     */
    default Timestamp mapCreatedAt(String createdAt) {
        if (createdAt == null) {
            return null;
        }
        return Timestamp.valueOf(createdAt);
    }

    /**
     * Maps a string representing the update timestamp to a {@link Timestamp} object.
     *
     * @param updatedAt String representation of the update timestamp.
     * @return {@link Timestamp} object representing the update timestamp.
     */
    default Timestamp mapUpdatedAt(String updatedAt) {
        if (updatedAt == null) {
            return null;
        }
        return Timestamp.valueOf(updatedAt);
    }

//    @Named("partialUpdate")
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    FirmAssignment applyPartialUpdates(@MappingTarget FirmAssignment firmAssignment, FirmAssignmentRequest firmAssignmentRequest);
//
////    @Named("partialUpdate")
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    @Mapping(source = "firmId", target = "firm.id")
////    @Mapping(source = "storageId", target = "storage.id")
////    @Mapping(source = "storageFiles", target = "storage.files")
////    FirmAnalysis applyPartialUpdates(@MappingTarget FirmAnalysis firmAnalysis, FirmAnalysisRequest firmAnalysisRequest);
//
//    @Named("partialUpdate")
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    ManagedCompany applyPartialUpdates(@MappingTarget ManagedCompany managedCompany, ManagedCompanyRequest managedCompanyRequest);
//
//    @Named("partialUpdate")
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    ManagedCompany applyPartialUpdates(@MappingTarget ManagedCompany managedCompany, ManagedCompanyResponse managedCompanyResponse);
//
//
//    @Named("partialUpdate")
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Treatment applyPartialUpdates(@MappingTarget Treatment treatment, TreatmentRequest treatmentRequest);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "activeMatterId", target = "activeMatter.id")
//    LMR applyPartialUpdates(@MappingTarget LMR LMR, LMRRequest LMRRequest);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "activeMatterId", target = "activeMatter.id")
//    Drug applyPartialUpdates(@MappingTarget Drug drug, DrugRequest drugRequest);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "managedCompanyId", target = "managedCompany.id")
//    QualityManager applyPartialUpdates(@MappingTarget QualityManager qualityManager, QualityManagerRequest qualityManagerRequest);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "storageId", target = "storage.id")
//    Image applyPartialUpdates(@MappingTarget Image image, ImageRequest imageRequest);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "cultureId", target = "culture.id")
//    Variety applyPartialUpdates(@MappingTarget Variety variety, VarietyRequest varietyRequest);
//
////    @Named("partialUpdate")
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    AuditFirm applyPartialUpdates(@MappingTarget AuditFirm auditFirm, AuditFirmResponse auditFirmResponse);
//
////    @Named("partialUpdate")
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    ConsultancyFirm applyPartialUpdates(@MappingTarget ConsultancyFirm consultancyFirm, ConsultancyFirmResponse consultancyFirmResponse);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "auditFirmId", target = "auditFirm.id")
//    ExternalAuditor applyPartialUpdates(@MappingTarget ExternalAuditor externalAuditor, ExternalAuditorRequest externalAuditorRequest);
//
////    @Named("partialUpdate")
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    ExternalAuditor applyPartialUpdates(@MappingTarget ExternalAuditor externalAuditor, ExternalAuditorResponse externalAuditorResponse);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "consultancyFirmId", target = "consultancyFirm.id")
//    ExternalConsultant applyPartialUpdates(@MappingTarget ExternalConsultant externalConsultant, ExternalConsultantRequest externalConsultantRequest);
//
////    @Named("partialUpdate")
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    ExternalConsultant applyPartialUpdates(@MappingTarget ExternalConsultant externalConsultant, ExternalConsultantResponse externalConsultantResponse);
//
//    @Named("partialUpdate")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "managedCompanyId", target = "managedCompany.id")
//    SupervisoryBoardMember applyPartialUpdates(@MappingTarget SupervisoryBoardMember supervisoryBoardMember, SupervisoryBoardMemberRequest supervisoryBoardMemberRequest);
//
//    @Named("toEntity")
//    FirmResponsible toEntity(FirmResponsibleResponse firmResponsibleResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Variety applyPartialUpdates(@MappingTarget Variety variety, VarietyResponse varietyResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "auditTypeName", target = "auditType.name")
//    AuditChecklist applyPartialUpdates(@MappingTarget AuditChecklist auditChecklist, AuditChecklistResponse auditChecklistResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    AccountManager applyPartialUpdates(@MappingTarget AccountManager accountManager, AccountManagerResponse accountManagerResponse);
//
////    @Mapping(target = "firmAssignments.InDuty", expression = "java(firmAssignmentsToFirmAssignmentInDuties(firm.getFirmAssignments()))")
//    @Mapping(source = "firmAssignments", target = "firmAssignments")
//    FirmResponse toDto1(Firm firm);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    @Mapping(source = "firmAssignments", target = "firmAssignments")
//    Firm partialUpdate(@MappingTarget Firm firm, FirmResponse firmResponse);
//
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    @Mapping(source = "firmName", target = "firm.name")
////    Parcel applyPartialUpdates(@MappingTarget Parcel parcel, ParcelResponse parcelResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    FirmAssignment applyPartialUpdates(@MappingTarget FirmAssignment firmAssignment, FirmAssignmentResponse firmAssignmentResponse);
//
////    @InheritConfiguration(name = "toEntity")
////    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
////    Parcel applyPartialUpdates(@MappingTarget Parcel parcel, ParcelResponse parcelResponse);
////
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "fileOwnerId", target = "fileOwner.id")
//    File applyPartialUpdates(@MappingTarget File file, FileResponse fileResponse);
////
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "firmName", target = "firm.name")
//    FirmAnalysis applyPartialUpdates(@MappingTarget FirmAnalysis firmAnalysis, FirmAnalysisResponse firmAnalysisResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "storageId", target = "storage.id")
//    Image applyPartialUpdates(@MappingTarget Image image, ImageResponse imageResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "storageId", target = "storage.id")
//    AuditFirm applyPartialUpdates(@MappingTarget AuditFirm auditFirm, AuditFirmResponse auditFirmResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "storageId", target = "storage.id")
//    ConsultancyFirm applyPartialUpdates(@MappingTarget ConsultancyFirm consultancyFirm, ConsultancyFirmResponse consultancyFirmResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "drugCommercialName", target = "drug.commercialName")
//    Enemy applyPartialUpdates(@MappingTarget Enemy enemy, EnemyResponse enemyResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "storageId", target = "storage.id")
//    ExternalAuditor applyPartialUpdates(@MappingTarget ExternalAuditor externalAuditor, ExternalAuditorResponse externalAuditorResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    ExternalConsultant applyPartialUpdates(@MappingTarget ExternalConsultant externalConsultant, ExternalConsultantResponse externalConsultantResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    LMR applyPartialUpdates(@MappingTarget LMR LMR, LMRResponse LMRResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    SupervisoryBoardMember applyPartialUpdates(@MappingTarget SupervisoryBoardMember supervisoryBoardMember, SupervisoryBoardMemberResponse supervisoryBoardMemberResponse);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Treatment applyPartialUpdates(@MappingTarget Treatment treatment, TreatmentResponse treatmentResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "activeMatterName", target = "activeMatter.name")
//    Drug applyPartialUpdates(@MappingTarget Drug drug, DrugResponse drugResponse);
}