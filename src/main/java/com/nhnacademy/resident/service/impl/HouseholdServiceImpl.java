package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.dto.request.HouseholdRequest;
import com.nhnacademy.resident.domain.dto.response.HouseholdResponse;
import com.nhnacademy.resident.entity.Household;
import com.nhnacademy.resident.repository.HouseholdRepository;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.service.HouseholdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    private final ResidentRepository residentRepository;
    private final HouseholdRepository householdRepository;

    public HouseholdServiceImpl(ResidentRepository residentRepository,
                                HouseholdRepository householdRepository) {
        this.residentRepository = residentRepository;
        this.householdRepository = householdRepository;
    }


    @Transactional
    @Override
    public HouseholdResponse createHousehold(HouseholdRequest request) {
        householdRepository.save(Household.builder()
            .householdCompositionDate(request.getHouseholdCompositionDate())
            .householdCompositionReasonCode(request.getCompositionReasonCode())
            .householdSerialNumber(request.getHouseholdSerialNumber())
            .resident(residentRepository.findById(request.getHouseholdResidentSerialNumber()).get())
            .currentHouseMovementAddress(request.getCurrentHouseMovementAddress())
            .build());


        return householdRepository.queryByHouseholdSerialNumber(request.getHouseholdSerialNumber());
    }
}
