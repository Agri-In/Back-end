package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Domains.Entities.Business.AuditType;
import com.audit.agriin.Domains.Entities.Business.FileOwner;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Enums.AuditStatus;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper.AuditMapper;
import com.audit.agriin.Reports.Templates.Audit.AuditReport;
import com.audit.agriin.Repositories.AuditRepository;
import com.audit.agriin.Repositories.AuditTypeRepository;
import com.audit.agriin.Repositories.FileStorageRepository;
import com.audit.agriin.Repositories.FirmRepository;
import com.audit.agriin.Services.Specification.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of the {@link com.audit.agriin.Services.Specification.AuditService} interface.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuditServiceImp extends _ServiceImp<UUID, AuditRequest, AuditResponse, Audit, AuditRepository, AuditMapper> implements AuditService {
    private final FirmRepository firmRepository;
    private final AuditTypeRepository auditTypeRepository;
    private final FileStorageRepository storageRepository;

    @Override
    public Optional<AuditResponse> create(AuditRequest request) {

        List<Firm> firms = firmRepository.findAllById(request.firmIds());
        AuditType auditType = auditTypeRepository.findById(request.auditTypeId()).orElseThrow(() -> new ResourceNotCreatedException("No audit type found with the given id"));
        if (firms.isEmpty()) {
            throw new ResourceNotCreatedException("No firms found with the given ids");
        }
        Audit entityToCreate = mapper.toEntityFromRequest(request);
        entityToCreate.setFirms(firms);
        entityToCreate.setAuditType(auditType);

        try {
            assert repository != null;
            FileOwner storage  = new FileOwner();
            FileOwner createdStorage = storageRepository.save(storage);
            entityToCreate.setStorage(createdStorage);
            entityToCreate.setStatus(AuditStatus.PENDING);
            Audit createdEntity = repository.save(entityToCreate);

            return Optional.of(mapper.toResponse(createdEntity));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    @Override
    public Optional<Audit> getAuditById(UUID id) {
        return Optional.empty();
    }

    public void generateReport(String type) throws JRException, SQLException, ParseException {
        List<Audit> audits = repository.findAll();
        log.info("Generating report");
        AuditReport report = new AuditReport();
        report.compile();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(audits);
        System.out.println("jasper file created");
        report.export(type, dataSource);
    }
}
