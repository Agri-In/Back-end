package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyRequest;
import com.audit.agriin.Domains.DTOs.Entities.Enemy.EnemyResponse;
import com.audit.agriin.Domains.Entities.Business.Enemy;
import com.audit.agriin.Services.Implemetation.EnemyServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/enemy")
public class EnemyController extends _Controller<UUID, EnemyRequest, EnemyResponse, EnemyServiceImp> {

    @PostMapping("/batch-create")
    public ResponseEntity<List<EnemyResponse>> batchCreate(@Valid @RequestBody String input){
        // Read the string and split to substrings based on the comma
        String[] substrings = input.split(",");

        // Convert the array to a Set to remove duplicates
        Set<String> uniqueSubstrings = new HashSet<>(Arrays.asList(substrings));

        try {
            for (String substring : uniqueSubstrings) {
                EnemyRequest enemy = new EnemyRequest(substring);
                service.create(enemy);
            }
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
