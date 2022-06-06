package com.nhnacademy.resident.controller.restcontroller;

import com.nhnacademy.resident.service.HouseholdService;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseholdRestController {
    private final ResidentService residentService;
    private final HouseholdService householdService;
}
