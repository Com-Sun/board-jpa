package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipCustom {
    List<FamilyRelationship> getResidentsHavingResidentSerialNumber(Long residentSerialNumber);
}
