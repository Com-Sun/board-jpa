package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.domain.dto.response.FamilyRelationshipResidentResponse;
import com.nhnacademy.resident.entity.FamilyRelationship;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipCustom {
    List<FamilyRelationship> getResidentsHavingResidentSerialNumber(Long residentSerialNumber);

    List<FamilyRelationshipResidentResponse> getRelationshipResidentResponsesHavingResidentSerialNumber(Long residentSerialNumber);
}
