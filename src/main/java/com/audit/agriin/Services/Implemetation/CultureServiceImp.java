package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureRequest;
import com.audit.agriin.Domains.DTOs.Entities.Culture.CultureResponse;
import com.audit.agriin.Domains.Entities.Business.Culture;
import com.audit.agriin.Mapper.CultureMapper;
import com.audit.agriin.Repositories.CultureRepository;
import com.audit.agriin.Services.Specification.CultureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Cacheable("cultures")
public class CultureServiceImp extends _ServiceImp<UUID, CultureRequest, CultureResponse, Culture, CultureRepository, CultureMapper> implements CultureService {
}
