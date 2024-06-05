package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestReq;
import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestRes;
import com.audit.agriin.Domains.DTOs.Entities.User.UserRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.UserResponses;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest;
import com.audit.agriin.Services.Implemetation.AccountServiceImpl;
import com.audit.agriin.Services.Implemetation.GroupRequestServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController extends _Controller<UUID, UserRequest, UserResponses, AccountServiceImpl>{

    private final GroupRequestServiceImpl grService;

    @PostMapping("/request-access")
    @PreAuthorize("hasAnyAuthority('DEFAULT_USER', 'ACCOUNT_MANAGER')")
    public ResponseEntity<GroupRequestRes> requestAccess(@Valid @RequestBody GroupRequestReq groupRequestReq){
        return ResponseEntity.ok(grService.requestAccess(groupRequestReq));
    }

    @PostMapping("/admin/approve-request/{requestId}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<GroupRequest> approveRequest(@PathVariable UUID requestId) {
        return ResponseEntity.ok(grService.approveRequest(requestId));
    }

    @PostMapping("/admin/reject-request/{requestId}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<GroupRequest> rejectRequest(@PathVariable UUID requestId) {
        return ResponseEntity.ok(grService.rejectRequest(requestId));
    }
}
