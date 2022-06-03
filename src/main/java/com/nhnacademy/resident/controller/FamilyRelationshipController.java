package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.domain.dto.response.FamilyRelationshipResidentResponse;
import com.nhnacademy.resident.entity.CertificateIssue;
import com.nhnacademy.resident.service.CertificateIssueService;
import com.nhnacademy.resident.service.FamilyRelationshipService;
import com.nhnacademy.resident.service.ResidentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;
    private final CertificateIssueService certificateIssueService;
    private final ResidentService residentService;

    public FamilyRelationshipController(
        FamilyRelationshipService familyRelationshipService,
        CertificateIssueService certificateIssueService,
        ResidentService residentService) {
        this.familyRelationshipService = familyRelationshipService;
        this.certificateIssueService = certificateIssueService;
        this.residentService = residentService;
    }

//    @GetMapping("residents/{serialNumber}/relationship")
//    public ModelAndView familyRelationship(@PathVariable(name = "serialNumber") Long serialNumber) {
//        ModelAndView mav = new ModelAndView("relationship/certification");
//        List<FamilyRelationship> relationships =
//            familyRelationshipService.getFamilyRelationshipList(serialNumber);
//        mav.addObject("residents", relationships);
//        mav.addObject("resident", residentService.getResidentBySerialNumber(serialNumber));
//
//        List<CertificateIssue> certifications = certificateIssueService.getCertificateListByResidentSerialNum(serialNumber);
//        CertificateIssue certification = certificateIssueService.getFamilyRelationshipCertification(certifications, "가족관계증명서");
//
//        mav.addObject("certification", certification);
//        return mav;
//    }

    @GetMapping("residents/{serialNumber}/relationship")
    public ModelAndView familyRelationship(@PathVariable(name = "serialNumber") Long serialNumber) {
        ModelAndView mav = new ModelAndView("relationship/certification");
        List<FamilyRelationshipResidentResponse> relationships =
            familyRelationshipService.getFamilyRelationshipList2(serialNumber);
        mav.addObject("residents", relationships);
        mav.addObject("resident", residentService.getResidentBySerialNumber(serialNumber));

        List<CertificateIssue> certifications = certificateIssueService.getCertificateListByResidentSerialNum(serialNumber);
        CertificateIssue certification = certificateIssueService.getFamilyRelationshipCertification(certifications, "가족관계증명서");

        mav.addObject("certification", certification);
        return mav;
    }
}
