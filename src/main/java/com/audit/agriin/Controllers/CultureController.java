package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureRequest;
import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureResponse;
import com.audit.agriin.Services.Implemetation.CultureServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/culture")
public class CultureController extends _Controller<UUID, CultureRequest, CultureResponse, CultureServiceImp>{
}
