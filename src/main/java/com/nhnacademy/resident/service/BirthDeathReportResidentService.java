package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import java.util.List;

public interface BirthDeathReportResidentService {
    List<BirthDeathReportResidentResponse> getDeathReportResidentListBySerialNum(Long serialNum);
}
