package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugRequest;
import com.audit.agriin.Domains.DTOs.Entities.Drug.DrugResponse;
import com.audit.agriin.Services.Implemetation.DrugServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DrugControllerTest {

    @InjectMocks
    private DrugController drugController;

    @Mock
    private DrugServiceImp drugService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(drugController).build();
    }

    @Test
    public void testCreate() throws Exception {
        DrugResponse drugResponse = new DrugResponse();
        drugResponse.setId(UUID.randomUUID());

        when(drugService.create(any(DrugRequest.class))).thenReturn(Optional.of(drugResponse));

        mockMvc.perform(post("/api/v1/drug")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Drug\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        DrugResponse drugResponse = new DrugResponse();
        drugResponse.setId(UUID.randomUUID());

        when(drugService.update(any(DrugResponse.class))).thenReturn(Optional.of(drugResponse));

        mockMvc.perform(put("/api/v1/drug/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Drug\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/v1/drug/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        DrugResponse drugResponse = new DrugResponse();
        drugResponse.setId(UUID.randomUUID());

        when(drugService.getById(any(UUID.class))).thenReturn(Optional.of(drugResponse));

        mockMvc.perform(get("/api/v1/drug/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/api/v1/drug")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}