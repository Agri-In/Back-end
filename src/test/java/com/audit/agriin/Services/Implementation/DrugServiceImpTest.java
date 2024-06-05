package com.audit.agriin.Services.Implementation;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Domains.Entities.Business.ActiveMatter;
import com.audit.agriin.Domains.Entities.Business.Drug;
import com.audit.agriin.Domains.Enums.DosageUnit;
import com.audit.agriin.Domains.Enums.DrugCharacter;
import com.audit.agriin.Domains.Enums.DrugType;
import com.audit.agriin.Mapper.DrugMapper;
import com.audit.agriin.Repositories.ActiveMatterRepository;
import com.audit.agriin.Repositories.DrugRepository;
import com.audit.agriin.Services.Implemetation.DrugServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DrugServiceImpTest {

    @InjectMocks
    private DrugServiceImp drugService;

    @Mock
    private DrugRepository drugRepository;

    @Mock
    private ActiveMatterRepository activeMatterRepository;

    @Mock
    private DrugMapper drugMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

}