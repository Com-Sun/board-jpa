package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.domain.FamilyRelationshipRequestDTO;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.service.FamilyRelationshipService;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyRelationshipRestController {
    private final FamilyRelationshipService familyRelationshipService;
    private final ResidentService residentService;

    public FamilyRelationshipRestController(
        FamilyRelationshipService familyRelationshipService, ResidentService residentService) {
        this.familyRelationshipService = familyRelationshipService;
        this.residentService = residentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/residents/{serialNumber}/relationship", produces = {MediaType.APPLICATION_JSON_VALUE})
    FamilyRelationship createFamilyRelationship(@RequestBody FamilyRelationshipRequestDTO relationshipRequestDTO, @PathVariable(name = "serialNumber") Long serialNumber) {
        return familyRelationshipService.createFamilyRelationship(relationshipRequestDTO, serialNumber);
    }

}
