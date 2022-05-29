package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.ResidentRequestDTO;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;

public interface ResidentService {
    Resident createResident(ResidentRequestDTO residentRequestDTO);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);

    List<Resident> getResidentList();
}
