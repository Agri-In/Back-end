package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterRequest;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Mapper.ActiveMatterMapper;
import com.audit.agriin.Repositories.ActiveMatterRepository;
import com.audit.agriin.Services.Specification.ActiveMatterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActiveMatterServiceImp extends _ServiceImp<UUID, ActiveMatterRequest, ActiveMatterResponse, ActiveMatter, ActiveMatterRepository, ActiveMatterMapper> implements ActiveMatterService {
}
