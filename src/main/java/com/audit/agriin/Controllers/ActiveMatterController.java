package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterRequest;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
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
@RequestMapping("/api/v1/active-matter")
public class ActiveMatterController extends _Controller<UUID, ActiveMatterRequest, ActiveMatterResponse, com.audit.agriin.Services.Implemetation.ActiveMatterServiceImp>{
}
