package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.domain.ResidentDTO;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.service.ResidentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Resident createResident(@RequestBody ResidentDTO residentDTO) {
        return residentService.createResident(residentDTO);
    }

}
