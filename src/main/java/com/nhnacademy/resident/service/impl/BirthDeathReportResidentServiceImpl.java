package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.domain.dto.response.DeathReportResidentResponse;
import com.nhnacademy.resident.repository.birthdeathreportresident.BirthDeathReportResidentRepository;
import com.nhnacademy.resident.service.BirthDeathReportResidentService;
import java.util.List;
import java.util.stream.Collectors;
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

        List<BirthDeathReportResidentResponse> deathList =birthDeathReportResidentRepository.getBirthDeathReportResidentHavingSerialNumber(serialNum)
            .stream()
            .filter(x -> x.getBirthDeathTypeCode().equals("사망") && x.getResidentSerialNumber().equals(serialNum))
            .collect(Collectors.toList());

        return deathList;
    }

    @Override
    public List<DeathReportResidentResponse> getDeathReportResident(Long serialNum) {
        return birthDeathReportResidentRepository.getDeathReportResidentHavingSerialNumber(serialNum);
    }
}
