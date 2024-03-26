package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyResponse;
import com.audit.agriin.Domains.Entities.Business.Enemy;
import com.audit.agriin.Mapper.EnemyMapper;
import com.audit.agriin.Repositories.EnemyRepository;
import com.audit.agriin.Services.Specification.EnemyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnemyServiceImp extends _ServiceImp<UUID, EnemyRequest, EnemyResponse, Enemy, EnemyRepository, EnemyMapper> implements EnemyService {

}
