package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.service.FamilyRelationshipService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FamilyRelationshipController {
    public FamilyRelationshipController(
        FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    private final FamilyRelationshipService familyRelationshipService;

    @GetMapping("residents/{serialNumber}/relationship")
    public ModelAndView familyRelationship(@PathVariable(name = "serialNumber") Long serialNumber) {
        ModelAndView mav = new ModelAndView("relationship/certification");
        List<Resident> relationships = familyRelationshipService.getFamilyRelationshipList(serialNumber);
        mav.addObject("residents", relationships);
        return mav;
    }
}
