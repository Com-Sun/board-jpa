package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.FamilyRelationshipRequestDTO;
import com.nhnacademy.resident.entity.FamilyRelationship;

public interface FamilyRelationshipService {
    FamilyRelationship createFamilyRelationship(FamilyRelationshipRequestDTO familyRelationshipRequestDTO, Long serialNumber);

}
