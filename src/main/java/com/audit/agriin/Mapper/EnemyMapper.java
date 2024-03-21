package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyResponse;
import com.audit.agriin.Domains.Entities.Business.Enemy;

import java.util.UUID;

public interface EnemyMapper extends _Mapper<UUID, EnemyRequest, EnemyResponse, Enemy>{
}
