package com.nhnacademy.resident.controller.restcontroller;

import com.nhnacademy.resident.domain.dto.request.HouseholdRequest;
import com.nhnacademy.resident.domain.dto.response.HouseholdResponse;
import com.nhnacademy.resident.service.HouseholdService;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseholdRestController {
    private final ResidentService residentService;
    private final HouseholdService householdService;

    public HouseholdRestController(ResidentService residentService,
                                   HouseholdService householdService) {
        this.residentService = residentService;
        this.householdService = householdService;
    }

    @PostMapping(value = "/household")
    public HouseholdResponse createHousehold(@RequestBody HouseholdRequest request) {
        return householdService.createHousehold(request);
    }
}
