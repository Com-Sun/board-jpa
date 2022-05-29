package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.QFamilyRelationship;
import com.nhnacademy.resident.entity.QResident;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements
    FamilyRelationshipCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<Resident> getResidentsHavingResidentSerialNumber(Long residentSerialNumber) {
        QResident resident = QResident.resident;
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        List<Resident> residentList = from(familyRelationship)
            .innerJoin(familyRelationship.pk.resident, resident)
            .on(resident.eq(familyRelationship.pk.resident)
                .and(familyRelationship.pk.familyResidentSerialNumber.eq(residentSerialNumber)))
            .orderBy(familyRelationship.familyRelationshipCode.desc())
            .select(resident)
            .fetch();

        return residentList;
    }
}
