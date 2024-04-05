package com.audit.agriin.Services.Implementation;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Domains.Entities.Business.Firm;
import com.audit.agriin.Domains.Entities.Business.Parcel;
import com.audit.agriin.Mapper.ParcelMapper;
import com.audit.agriin.Mapper.ParcelMapperImpl;
import com.audit.agriin.Repositories.FirmRepository;
import com.audit.agriin.Repositories.ParcelRepository;
import com.audit.agriin.Services.Implemetation.ParcelServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ParcelServiceImpTest {

    @InjectMocks
    private ParcelServiceImp parcelService;

    @Mock
    private ParcelRepository parcelRepository;

    @Mock
    private FirmRepository firmRepository;

    private ParcelMapper parcelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        parcelMapper = new ParcelMapperImpl(); // instantiate the mapper
        parcelService.setMapper(parcelMapper); // set the mapper in the service
    }

    @Test
    public void testCreate() {
        ParcelRequest parcelRequest = new ParcelRequest("Parcel 1", 100.0, UUID.randomUUID());

        Firm firm = new Firm();
        firm.setId(UUID.randomUUID());

        Parcel parcel = new Parcel();
        parcel.setFirm(firm);

        when(parcelMapper.toEntityFromRequest(any())).thenReturn(parcel);
        when(firmRepository.findById(any())).thenReturn(Optional.of(firm));
        when(parcelRepository.save(any())).thenReturn(parcel);

        Optional<ParcelResponse> parcelResponse = parcelService.create(parcelRequest);

        assertEquals(parcel.getFirm().getName(), parcelResponse.get().getFirmName());
    }

}