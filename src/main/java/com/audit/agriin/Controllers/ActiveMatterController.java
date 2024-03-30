package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterRequest;
import com.audit.agriin.Domains.DTOs.Entities.ActiveMatter.ActiveMatterResponse;
import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyResponse;
import com.audit.agriin.Services.Implemetation.ActiveMatterServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/active-matter")
public class ActiveMatterController extends _Controller<UUID, ActiveMatterRequest, ActiveMatterResponse, ActiveMatterServiceImp>{


    @PostMapping("/batch-create")
    public ResponseEntity<List<EnemyResponse>> batchCreate(@Valid @RequestBody String input){
        // Read the string and split to substrings based on the comma
        String[] substrings = input.split(";");

        // Convert the array to a Set to remove duplicates
        Set<String> uniqueSubstrings = new HashSet<>(Arrays.asList(substrings));

        try {
            for (String substring : uniqueSubstrings) {
                ActiveMatterRequest activeMatter = new ActiveMatterRequest(substring);
                service.create(activeMatter);
            }
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
