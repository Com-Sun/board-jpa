package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.FamilyRelationshipRequestDTO;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;

public interface FamilyRelationshipService {
    FamilyRelationship createFamilyRelationship(FamilyRelationshipRequestDTO familyRelationshipRequestDTO, Long serialNumber);

    List<FamilyRelationship> getFamilyRelationshipList(Long serialNumber);

}
