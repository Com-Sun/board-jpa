package com.nhnacademy.resident.repository.birthdeathreportresident;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.domain.dto.response.DeathReportResidentResponse;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentCustom {
    List<BirthDeathReportResidentResponse> getBirthDeathReportResidentHavingSerialNumber(Long serialNumber);

    List<DeathReportResidentResponse> getDeathReportResidentHavingSerialNumber(Long serialNumber);

}
