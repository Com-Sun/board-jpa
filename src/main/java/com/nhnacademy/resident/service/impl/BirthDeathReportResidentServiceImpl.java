package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.repository.birthdeathreportresident.BirthDeathReportResidentRepository;
import com.nhnacademy.resident.service.BirthDeathReportResidentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    public BirthDeathReportResidentServiceImpl(
        BirthDeathReportResidentRepository birthDeathReportResidentRepository) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
    }

    @Override
    public List<BirthDeathReportResidentResponse> getDeathReportResidentListBySerialNum(
        Long serialNum) {

        return birthDeathReportResidentRepository.getBirthDeathReportResidentHavingSerialNumber(serialNum);
    }
}
