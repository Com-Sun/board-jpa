package com.nhnacademy.resident.controller.restcontroller;

import com.nhnacademy.resident.domain.dto.request.ResidentModifyRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRequest;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class ResidentsRestController {
    private final ResidentService residentService;

    public ResidentsRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/residents", consumes = {"application/json"})
    public Resident createResident(@RequestBody ResidentRequest residentRequest) {
        return residentService.createResident(residentRequest);
    }

    @PutMapping(value = "/residents/{serialNumber}")
    public Resident modifyResident(@RequestBody ResidentModifyRequest modifyRequest, @PathVariable(name = "serialNumber") Long serialNumber) {
        Resident resident = residentService.getResidentBySerialNumber(serialNumber);
        resident.setDeathPlaceCode(modifyRequest.getDeathPlaceCode());
        resident.setDeathDate(modifyRequest.getDeathDate());
        resident.setDeathPlaceAddress(modifyRequest.getDeathPlaceAddress());

        return resident;
    }
}
