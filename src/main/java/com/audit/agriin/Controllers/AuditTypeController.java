package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditType.AuditTypeResponse;
import com.audit.agriin.Services.Implemetation.AuditTypeServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/audit-type")
public class AuditTypeController extends _Controller<UUID, AuditTypeRequest, AuditTypeResponse, AuditTypeServiceImp>{

//    @PostMapping("/string")
//    private String returnString(){
//        System.out.println("hhh");
//        return "Hello World";
//    }
}
