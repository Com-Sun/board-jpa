package com.nhnacademy.resident.controller.restcontroller;

import com.nhnacademy.resident.domain.dto.request.ResidentRegisterRequest;
import com.nhnacademy.resident.domain.dto.response.ResidentRegisterResponse;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
    private final ResidentService residentService;

    public LoginRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping(value = "register/{serialNum}")
    public ResidentRegisterResponse registerResident(@PathVariable (name = "serialNum") Long serialNum, @RequestBody ResidentRegisterRequest request) {
        return residentService.registerResident(serialNum, request);
    }
}
