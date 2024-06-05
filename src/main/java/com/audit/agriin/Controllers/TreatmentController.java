package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentRequest;
import com.audit.agriin.Domains.DTOs.Entities.Treatment.TreatmentResponse;
import com.audit.agriin.Services.Implemetation.TreatmentServiceImp;
import com.audit.agriin.Services.Specification.TreatmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/treatment")
public class TreatmentController extends _Controller<UUID, TreatmentRequest, TreatmentResponse, TreatmentServiceImp>{


}
