package com.nhnacademy.resident.repository;

import com.nhnacademy.resident.domain.dto.response.ResidentRegisterResponse;
import com.nhnacademy.resident.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByNameAndResidentRegistrationNumber(String name, String residentRegistrationNumber);

    Resident findByUserId(String id);

    ResidentRegisterResponse getByResidentSerialNumber(Long SerialNumber);
}
