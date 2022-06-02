package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.QFamilyRelationship;
import com.nhnacademy.resident.entity.QResident;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements
    FamilyRelationshipCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationship> getResidentsHavingResidentSerialNumber(Long residentSerialNumber) {
        QResident resident = QResident.resident;
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        List<FamilyRelationship> residentList = from(familyRelationship)
            .innerJoin(resident)
            .on(familyRelationship.pk.resident.eq(resident)
                .and(familyRelationship.pk.familyResidentSerialNumber.eq(residentSerialNumber)))
            .orderBy(familyRelationship.familyRelationshipCode.desc())
            .fetch();

        return residentList;
    }
}