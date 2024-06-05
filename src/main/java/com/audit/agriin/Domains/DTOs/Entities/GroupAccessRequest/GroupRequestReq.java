package com.audit.agriin.Domains.DTOs.Entities.GroupAccessRequest;

import com.audit.agriin.Domains.DTOs._Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * A request to create a new group access request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GroupRequestReq(String userEmail, String groupName) implements _Request {
}