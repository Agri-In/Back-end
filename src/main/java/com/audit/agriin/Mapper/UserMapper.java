package com.audit.agriin.Mapper;

import com.audit.agriin.Domains.DTOs.Entities.User.UserRequest;
import com.audit.agriin.Domains.DTOs.Entities.User.UserResponses;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

/**
 * Mapper interface for converting between {@link UserRequest}, {@link UserResponses}, and {@link User} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UserMapper extends _Mapper<UUID, UserRequest, UserResponses, User> {

//    @IterableMapping(qualifiedByName = "toResponse")
    @Override
    @Mapping(target = "userGroups", source = "userGroups")
    List<UserResponses> toResponse(List<User> user);

//    @IterableMapping(qualifiedByName = "toResponseFromEntity")
//    @Override
//    List<UserResponses> toResponseFromEntity(List<User> entity);
//
//    @Override
//    UserResponses toResponseFromEntity(User entity);

//    User toEntity(UserRequest userRequest);
//
//    User toEntity(UserResponses userResponses);
//
    @Override
    @Mapping(target = "userGroups", source = "userGroups")
    UserResponses toResponse(User user);
//
//    @IterableMapping(qualifiedByName = "toEntity")
//    List<User> toEntity(List<UserRequest> userRequest);
}