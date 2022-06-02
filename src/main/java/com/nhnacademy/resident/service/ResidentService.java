package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.ResidentRequest;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;

public interface ResidentService {
    Resident createResident(ResidentRequest residentRequest);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);

    List<Resident> getResidentList();

    Resident getResidentBySerialNumber(Long serialNumber);
}
