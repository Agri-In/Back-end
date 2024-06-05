package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestReq;
import com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest.GroupRequestRes;
import com.audit.agriin.Domains.DTOs.Entities.User.ChangeGroupRequest;
import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Domains.Enums.RequestStatus;
import com.audit.agriin.Mapper.GroupRequestMapper;
import com.audit.agriin.Repositories.GroupRepository;
import com.audit.agriin.Repositories.GroupRequestRepository;
import com.audit.agriin.Repositories.UserRepository;
import com.audit.agriin.Services.Specification.GroupRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupRequestServiceImpl extends _ServiceImp<UUID, GroupRequestReq, GroupRequestRes, GroupRequest, GroupRequestRepository, GroupRequestMapper> implements GroupRequestService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    public GroupRequestRes requestAccess(GroupRequestReq requestReq) {
        GroupRequest groupRequest = new GroupRequest();
        Group group = groupRepository.findGroupByName(requestReq.groupName());
        User user = userRepository.findUserByEmail(requestReq.userEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        groupRequest.setUser(user);
        groupRequest.setGroup(group);
        groupRequest.setStatus(RequestStatus.PENDING);
        try {
            GroupRequest createdEntity = repository.save(groupRequest);
            return mapper.toResponse(createdEntity);
        } catch (Exception e) {
            log.error("Error while saving group request: {}", e.getMessage());
            throw new RuntimeException("Error while saving group request");
        }
    }

    public GroupRequest approveRequest(UUID requestId) {
        Optional<GroupRequest> optionalGroupRequest = repository.findById(requestId);

        GroupRequest groupRequest = optionalGroupRequest.get();
        ChangeGroupRequest changeGroupRequest = new ChangeGroupRequest(groupRequest.getUser().getEmail(), groupRequest.getGroup().getName());
        try {
            userService.changeGroup(changeGroupRequest);
        } catch (Exception e) {
            log.error("Error while changing group: {}", e.getMessage());
            throw new RuntimeException("Error while changing group");
        }
        groupRequest.setStatus(RequestStatus.APPROVED);
        return repository.save(groupRequest);
    }

    public GroupRequest rejectRequest(UUID requestId) {
        Optional<GroupRequest> optionalGroupRequest = repository.findById(requestId);
        if (optionalGroupRequest.isPresent()) {
            GroupRequest groupRequest = optionalGroupRequest.get();
            groupRequest.setStatus(RequestStatus.REJECTED);
            return repository.save(groupRequest);
        } else {
            throw new RuntimeException("Group request not found");
        }
    }
}
