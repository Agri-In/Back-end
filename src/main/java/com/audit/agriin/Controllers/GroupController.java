package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Group.GroupRequest;
import com.audit.agriin.Domains.DTOs.Entities.Group.GroupResponse;
import com.audit.agriin.Services.Implemetation.GroupServiceImp;
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
@RequestMapping("/api/v1/permissions")
public class GroupController extends _Controller<UUID, GroupRequest, GroupResponse, GroupServiceImp>{
}
