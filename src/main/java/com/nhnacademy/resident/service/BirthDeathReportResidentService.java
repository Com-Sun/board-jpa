package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.domain.dto.response.DeathReportResidentResponse;
import java.util.List;

public interface BirthDeathReportResidentService {
    List<BirthDeathReportResidentResponse> getDeathReportResidentListBySerialNum(Long serialNum);

    List<DeathReportResidentResponse> getDeathReportResident(Long serialNum);
}
