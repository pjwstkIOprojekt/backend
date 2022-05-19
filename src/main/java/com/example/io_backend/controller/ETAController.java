package com.example.io_backend.controller;

import com.example.io_backend.dto.Eta.EtaDto;
import com.example.io_backend.dto.Eta.LocationDto;
import com.example.io_backend.service.ETAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping(path = "/eta")
@RequiredArgsConstructor
public class ETAController {

    private final ETAService etaService;

    @GetMapping("")
    public ResponseEntity<List<EtaDto>> getEtaOfAmbulance(@RequestBody LocationDto ... locationDtos){
        return new ResponseEntity<>(etaService.getEtaOfAmbulance(locationDtos), HttpStatus.OK);
    }

}
