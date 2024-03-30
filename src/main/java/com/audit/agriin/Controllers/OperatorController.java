package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorRequest;
import com.audit.agriin.Domains.DTOs.Entities.Operator.OperatorResponse;
import com.audit.agriin.Services.Implemetation.OperatorServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/operator")
public class OperatorController extends _Controller<UUID, OperatorRequest, OperatorResponse, OperatorServiceImp>{
}
