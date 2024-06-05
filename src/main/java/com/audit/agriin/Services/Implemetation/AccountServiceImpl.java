package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestReq;
import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestRes;
import com.audit.agriin.Domains.DTOs.Entities.User.UserRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.UserResponses;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Domains.Enums.RequestStatus;
import com.audit.agriin.Mapper.UserMapper;
import com.audit.agriin.Repositories.GroupRepository;
import com.audit.agriin.Repositories.GroupRequestRepository;
import com.audit.agriin.Repositories.UserRepository;
import com.audit.agriin.Services.Specification.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends _ServiceImp<UUID, UserRequest, UserResponses, User, UserRepository, UserMapper> implements AccountService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;



}
