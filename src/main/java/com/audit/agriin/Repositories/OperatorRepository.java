package com.audit.agriin.Repositories;

import com.audit.agriin.Domains.Entities.Business.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, UUID> {
}
