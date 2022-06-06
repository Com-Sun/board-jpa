package com.nhnacademy.resident.repository;

import com.nhnacademy.resident.domain.dto.response.ResidentResponse;
import com.nhnacademy.resident.entity.Resident;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByNameAndResidentRegistrationNumber(String name, String residentRegistrationNumber);

    Resident findByUserId(String id);

    ResidentResponse getByResidentSerialNumber(Long SerialNumber);

    Optional<Resident> findByEmail(String email);
}
