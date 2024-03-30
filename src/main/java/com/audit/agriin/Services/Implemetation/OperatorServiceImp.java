package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorRequest;
import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorResponse;
import com.audit.agriin.Domains.Entities.Business.*;
import com.audit.agriin.Exceptions.ResourceNotCreatedException;
import com.audit.agriin.Mapper.OperatorMapper;
import com.audit.agriin.Repositories.OperatorRepository;
import com.audit.agriin.Services.Specification.OperatorService;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class OperatorServiceImp extends _ServiceImp<UUID, OperatorRequest, OperatorResponse, Operator, OperatorRepository, OperatorMapper> implements OperatorService {

    @Override
    public Optional<OperatorResponse> create(OperatorRequest request) {
        Operator entityToCreate = mapper.toEntityFromRequest(request);
        try {
            assert repository != null;
            Operator createdEntity = repository.save(entityToCreate);
            return Optional.of(mapper.toResponse(createdEntity));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    @Override
    public Optional<Operator> getOperatorById(UUID id) {
        return Optional.empty();
    }

//    public void generateReport(String type) throws JRException, SQLException, ParseException {
//        List<Operator> audits = repository.findAll();
//        log.info("Generating report");
//        OperatorReport report = new OperatorReport();
//        report.compile();
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(audits);
//        System.out.println("jasper file created");
//        report.export(type, dataSource);
//    }
}
