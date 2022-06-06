package com.nhnacademy.resident.repository.birthdeathreportresident;

import com.nhnacademy.resident.domain.dto.response.BirthDeathReportResidentResponse;
import com.nhnacademy.resident.entity.BirthDeathReportResident;
import com.nhnacademy.resident.entity.QBirthDeathReportResident;
import com.nhnacademy.resident.entity.QResident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


@Repository
public class BirthDeathReportResidentRepositoryImpl extends QuerydslRepositorySupport implements BirthDeathReportResidentCustom{
    public BirthDeathReportResidentRepositoryImpl() {
        super(BirthDeathReportResident.class);
    }

    @Override
    public List<BirthDeathReportResidentResponse> getBirthDeathReportResidentHavingSerialNumber(
        Long serialNumber) {

        QResident resident = QResident.resident;
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;

        List<BirthDeathReportResidentResponse> birthDeathLists = from(birthDeathReportResident)
            .innerJoin(resident)
            .on(birthDeathReportResident.pk.reportResidentSerialNumber.eq(resident.residentSerialNumber)
                .and(birthDeathReportResident.pk.resident.residentSerialNumber.eq(serialNumber)))
            .select(Projections.bean(BirthDeathReportResidentResponse.class, resident.residentSerialNumber , birthDeathReportResident.pk.birthDeathTypeCode, birthDeathReportResident.pk.reportResidentSerialNumber, birthDeathReportResident.birthDeathReportDate, birthDeathReportResident.birthReportQualificationsCode, birthDeathReportResident.DeathReportQualificationsCode, birthDeathReportResident.emailAddress, birthDeathReportResident.phoneNumber, resident.name))
            .fetch();

        return birthDeathLists;
    }
}
