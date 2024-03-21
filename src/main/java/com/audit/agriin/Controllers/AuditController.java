package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditRequest;
import com.audit.agriin.Domains.DTOs.Entities.Audit.AuditResponse;
import com.audit.agriin.Domains.Entities.Business.Audit;
import com.audit.agriin.Services.Implemetation.AuditServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.UUID;

/**
 * Controller class for handling CRUD operations on Competition entities.
 * Exposes RESTful endpoints for managing Competition entities.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 * @see _Controller
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/audit")
public class AuditController extends _Controller<UUID, AuditRequest, AuditResponse, AuditServiceImp> {
    private final AuditServiceImp auditService;


    @GetMapping("/reports/{type}")
    public ResponseEntity<Audit> generateReport(@PathVariable String type) {
        try {
            auditService.generateReport(type);
            return ResponseEntity.ok().build();
        } catch (SQLException | ParseException | JRException e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
