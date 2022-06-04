package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.request.ResidentLoginRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRegisterRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRequest;
import com.nhnacademy.resident.domain.dto.response.ResidentRegisterResponse;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;

public interface ResidentService {
    Resident createResident(ResidentRequest residentRequest);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);

    List<Resident> getResidentList();

    Resident getResidentBySerialNumber(Long serialNumber);

    void doLogin(ResidentLoginRequest residentLoginRequest);

    ResidentRegisterResponse registerResident(Long serialNum, ResidentRegisterRequest request);
}
