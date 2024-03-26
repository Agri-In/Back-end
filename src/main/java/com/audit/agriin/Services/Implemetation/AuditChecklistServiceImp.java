package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistRequest;
import com.audit.agriin.Domains.DTOs.Entities.AuditChecklist.AuditChecklistResponse;
import com.audit.agriin.Domains.Entities.Business.AuditChecklist;
import com.audit.agriin.Mapper.AuditChecklistMapper;
import com.audit.agriin.Repositories.AuditChecklistRepository;
import com.audit.agriin.Services.Specification.AuditChecklistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuditChecklistServiceImp extends _ServiceImp<UUID, AuditChecklistRequest, AuditChecklistResponse, AuditChecklist, AuditChecklistRepository, AuditChecklistMapper> implements AuditChecklistService {
}
