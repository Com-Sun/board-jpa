package com.nhnacademy.resident.controller.restcontroller;

import com.nhnacademy.resident.domain.dto.FamilyRelationshipRequest;
import com.nhnacademy.resident.domain.dto.ModifyFamilyRelationshipRequest;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.service.FamilyRelationshipService;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PostMapping(value = "/residents/{serialNumber}/relationship", consumes = "application/json")
    FamilyRelationship createFamilyRelationship(@RequestBody
                                                    FamilyRelationshipRequest relationshipRequestDTO,
                                                @PathVariable(name = "serialNumber")
                                                    Long serialNumber) {
        return familyRelationshipService.createFamilyRelationship(relationshipRequestDTO,
            serialNumber);
    }

    @PutMapping(value = "/residents/{serialNumber}/relationship/{familySerialNumber}")
    FamilyRelationship modifyFamilyRelationship(@RequestBody
                                                    ModifyFamilyRelationshipRequest modifyRequest,
                                                @PathVariable(name = "serialNumber"
                                                )
                                                    Long serialNumber,
                                                @PathVariable(name = "familySerialNumber")
                                                    Long familySerialNumber) {


        return familyRelationshipService.modifyRelationship(modifyRequest, serialNumber,
            familySerialNumber);
    }

    @DeleteMapping(value = "/residents/{serialNumber}/relationship/{familySerialNumber}")
    FamilyRelationship deleteFamilyRelationship(@PathVariable(name = "serialNumber") Long serialNumber, @PathVariable(name = "familySerialNumber") Long familySerialNumber) {
        return familyRelationshipService.deleteRelationship(serialNumber, familySerialNumber);
    }
}
