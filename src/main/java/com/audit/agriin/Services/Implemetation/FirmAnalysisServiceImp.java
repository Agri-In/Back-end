package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisRequest;
import com.audit.agriin.Domains.DTOs.Entities.FirmAnalysis.FirmAnalysisResponse;
import com.audit.agriin.Domains.Entities.Business.FirmAnalysis;
import com.audit.agriin.Mapper.FirmAnalysisMapper;
import com.audit.agriin.Repositories.FirmAnalysisRepository;
import com.audit.agriin.Services.Specification.FirmAnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FirmAnalysisServiceImp extends _ServiceImp<UUID, FirmAnalysisRequest, FirmAnalysisResponse, FirmAnalysis, FirmAnalysisRepository, FirmAnalysisMapper> implements FirmAnalysisService {
}
