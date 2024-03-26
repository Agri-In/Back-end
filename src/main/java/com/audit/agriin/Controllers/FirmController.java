package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmRequest;
import com.audit.agriin.Domains.DTOs.Entities.Firm.FirmResponse;
import com.audit.agriin.Services.Implemetation.FirmServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/firm")
public class FirmController extends _Controller<UUID, FirmRequest, FirmResponse, FirmServiceImp>{
}
