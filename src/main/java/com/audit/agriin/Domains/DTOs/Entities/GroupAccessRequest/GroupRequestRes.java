package com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest;

import com.audit.agriin.Domains.DTOs._Response;
import com.audit.agriin.Domains.Enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link com.audit.agriin.Domains.Entities.NonCorporate.GroupRequest}
 */

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupRequestRes implements _Response {
    Timestamp createdAt;
    Timestamp updatedAt;
    Long version;
    UUID id;
    String userEmail;
    String groupGroupName;
    RequestStatus status;
}