package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.ResidentDTO;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.service.ResidentService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public Resident createResident(ResidentDTO residentDTO) {

        return residentRepository.save(Resident.builder()
            .residentSerialNumber(residentDTO.getSerialNumber())
            .name(residentDTO.getName())
            .residentRegistrationNumber(residentDTO.getRegistrationNumber())
            .genderCode(residentDTO.getGender())
            .birthDate(residentDTO.getBirthDate())
            .birthPlaceCode(residentDTO.getBirthPlace())
            .registrationBaseAddress(residentDTO.getBaseAddress())
            .build());
    }

    @Override
    public Resident getResident(String name, String residentRegistrationNumber) {
        return residentRepository.findByNameAndResidentRegistrationNumber(name, residentRegistrationNumber);
    }


    @Transactional
    @Override
    public Resident modifyResident(Resident resident) {
        return residentRepository.save(resident);
    }
}
