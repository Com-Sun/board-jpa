package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.SecurityUser;
import com.nhnacademy.resident.domain.dto.request.ResidentLoginRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRegisterRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRequest;
import com.nhnacademy.resident.domain.dto.response.ResidentResponse;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;

public interface ResidentService {
    ResidentResponse createResident(ResidentRequest residentRequest);

    Resident getResident(String name, String residentRegistrationNumber);

    Resident modifyResident(Resident resident);

    List<Resident> getResidentList();

    Resident getResidentBySerialNumber(Long serialNumber);

    void doLogin(ResidentLoginRequest residentLoginRequest);

    ResidentResponse registerResident(Long serialNum, ResidentRegisterRequest request);

    SecurityUser checkExistEmail(String email);
}
