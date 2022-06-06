package com.nhnacademy.resident.controller;


import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.service.BirthDeathReportResidentService;
import com.nhnacademy.resident.service.ResidentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BirthDeathReportResidentController {
    private final BirthDeathReportResidentService birthDeathReportResidentService;
    private final ResidentService residentService;

    public BirthDeathReportResidentController(
        BirthDeathReportResidentService birthDeathReportResidentService,
        ResidentService residentService) {
        this.birthDeathReportResidentService = birthDeathReportResidentService;
        this.residentService = residentService;
    }

    @GetMapping("/death/report/{serialNum}")
    public ModelAndView deathReport(@PathVariable(name = "serialNum") Long serialNum) {
        ModelAndView mav = new ModelAndView("report/death");

        List<BirthDeathReportResidentResponse> deathLists =
            birthDeathReportResidentService.getDeathReportResidentListBySerialNum(serialNum);
        mav.addObject("deathLists", deathLists);

        return mav;
    }
}
