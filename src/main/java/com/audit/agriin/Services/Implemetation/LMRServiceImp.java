package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRResponse;
import com.audit.agriin.Domains.Entities.Business.LMR;
import com.audit.agriin.Mapper.LMRMapper;
import com.audit.agriin.Repositories.LmrRepository;
import com.audit.agriin.Services.Specification.LMRService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LMRServiceImp extends _ServiceImp<UUID, LMRRequest, LMRResponse, LMR, LmrRepository, LMRMapper> implements LMRService {
}
