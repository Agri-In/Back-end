package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Services.Implemetation.LMRServiceImp;
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
@RequestMapping("/api/v1/lmr")
public class LMRController extends _Controller<UUID, LMRRequest, LMRResponse, LMRServiceImp>{
}
