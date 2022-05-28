package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.ResidentRequestDTO;
import com.nhnacademy.resident.entity.Resident;

public interface ResidentService {
    Resident createResident(ResidentRequestDTO residentRequestDTO);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);
}
