package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.ResidentDTO;
import com.nhnacademy.resident.entity.Resident;
import java.time.LocalDateTime;

public interface ResidentService {
    Resident createResident(ResidentDTO residentDTO);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);
}
