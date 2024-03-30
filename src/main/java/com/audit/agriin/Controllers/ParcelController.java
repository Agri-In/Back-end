package com.audit.agriin.Controllers;

import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelRequest;
import com.audit.agriin.Domains.DTOs.Entities.Parcel.ParcelResponse;
import com.audit.agriin.Services.Implemetation.ParcelServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/parcel")
public class ParcelController extends _Controller<UUID, ParcelRequest, ParcelResponse, ParcelServiceImp>{
}
