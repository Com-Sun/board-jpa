package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.domain.ResidentRequestDTO;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResidentsRestController {
    private final ResidentService residentService;

    public ResidentsRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/residents", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Resident createResident(@RequestBody ResidentRequestDTO residentRequestDTO) {
        return residentService.createResident(residentRequestDTO);
    }

}
