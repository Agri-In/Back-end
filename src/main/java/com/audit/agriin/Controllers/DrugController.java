package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequestBean;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.DTOs.Entities.LMR.LMRRequest;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.audit.agriin.Domains.Enums.Region;
import com.audit.agriin.Services.Implemetation.DrugServiceImp;
import com.audit.agriin.Services.Specification.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/drug")
public class DrugController extends _Controller<UUID, DrugRequest, DrugResponse, DrugServiceImp>{



    @PostMapping("/batch-create")
    public Optional<List<DrugResponse>> batchCreate(@RequestAttribute MultipartFile csvFile) {

        if (csvFile == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CSV file is required");

        try {
            // Parse the CSV file
            Reader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
            CsvToBean<DrugRequestBean> csvToBean = new CsvToBeanBuilder<DrugRequestBean>(reader)
                    .withType(DrugRequestBean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();


            // Convert each row in the CSV file to a DrugRequest object
            List<DrugRequest> drugRequests = new ArrayList<>();
            try {
                for (DrugRequestBean drugRequestBean : csvToBean.parse()) {
                    drugRequests.add(convertToDrugRequest(drugRequestBean));
                }
            } catch (Exception e) {
                log.error("Error occurred while parsing CSV file", e);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error occurred while parsing CSV file", e);
            }

            // For each DrugRequest object, call the create method of the DrugService
            List<DrugResponse> drugResponses = new ArrayList<>();
            for (DrugRequest drugRequest : drugRequests) {
                Optional<DrugResponse> drugResponse = service.create(drugRequest);
                drugResponse.ifPresent(drugResponses::add);
            }

            return Optional.of(drugResponses);
        } catch (Exception e) {
            log.error("Error occurred while batch creating drugs from CSV file", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while batch creating drugs from CSV file", e);
        }
    }


    public DrugRequest convertToDrugRequest(DrugRequestBean drugRequestBean) {

        return new DrugRequest(
                drugRequestBean.getCommercialName(),
                "dscdsvsvs",
                new HashSet<>(List.of(UUID.randomUUID())),
                drugRequestBean.getDosage(),
                Enum.valueOf(DosageUnit.class, drugRequestBean.getDosageUnit()
//                        .replace("/", "_")
                ),
//                new HashSet<>(List.of(drugRequestBean.getEnemyIds())),
                drugRequestBean.getDar(),
                drugRequestBean.getMaxApplication(),
                new HashSet<>(List.of(new LMRRequest(Region.AFRICA, "description", UUID.randomUUID()))),
                Enum.valueOf(DrugType.class, drugRequestBean.getDrugType()),
                Enum.valueOf(DrugCharacter.class, drugRequestBean.getDrugCharacter())
        );    }



    public File addHeadersToFile(File csvFile) {
        List<String> lines;
        try {
            lines = Files.readAllLines(csvFile.toPath());
            try (BufferedWriter writer = Files.newBufferedWriter(csvFile.toPath())) {
                writer.write("commercialName, dosage, dosageUnit, enemyIds, maxApplication, dar, drugType, drugCharacter"); // replace with your headers
                writer.newLine();
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            log.error("Error occurred while adding headers to CSV file", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while adding headers to CSV file", e);
        }
        return csvFile;
    }
}
