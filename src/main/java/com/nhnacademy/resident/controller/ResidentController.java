package com.nhnacademy.resident.controller;

import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.service.ResidentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping("/residents")
    public ModelAndView residents() {
        ModelAndView mav = new ModelAndView("residents");
        List<Resident> residentList = residentService.getResidentList();
        mav.addObject("residents", residentList);
        return mav;
    }
}
