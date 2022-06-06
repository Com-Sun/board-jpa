package com.nhnacademy.resident.repository.birthdeathreportresident;

import com.nhnacademy.resident.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk>, BirthDeathReportResidentCustom {
}
