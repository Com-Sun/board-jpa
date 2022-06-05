package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.domain.dto.response.FamilyRelationshipResidentResponse;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.QFamilyRelationship;
import com.nhnacademy.resident.entity.QResident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements
    FamilyRelationshipCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationship> getResidentsHavingResidentSerialNumber(
        Long residentSerialNumber) {
        QResident resident = QResident.resident;
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;


        List<FamilyRelationship> residentList =
            from(familyRelationship)
            .innerJoin(resident)
            .on(familyRelationship.pk.familyResidentSerialNumber.eq(resident.residentSerialNumber)
                .and(familyRelationship.pk.resident.residentSerialNumber.eq(residentSerialNumber)))
            .orderBy(familyRelationship.familyRelationshipCode.desc())
            .fetch();

        return residentList;
    }

    @Override
    public List<FamilyRelationshipResidentResponse> getRelationshipResidentResponsesHavingResidentSerialNumber(
        Long residentSerialNumber) {

        QResident resident = QResident.resident;
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        List<FamilyRelationshipResidentResponse> residentList = from(familyRelationship)
            .innerJoin(resident)
            .on(familyRelationship.pk.familyResidentSerialNumber.eq(resident.residentSerialNumber)
            .and(familyRelationship.pk.resident.residentSerialNumber.eq(residentSerialNumber)))
            .orderBy(familyRelationship.familyRelationshipCode.desc())
            .select(Projections.bean(FamilyRelationshipResidentResponse.class, familyRelationship.familyRelationshipCode, resident.name, resident.birthDate, resident.residentRegistrationNumber, familyRelationship.pk.familyResidentSerialNumber, resident.birthDate, resident.residentRegistrationNumber, resident.genderCode))
            .fetch();

        return residentList;
    }
}
