package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.request.FamilyRelationshipRequest;
import com.nhnacademy.resident.domain.dto.request.ModifyFamilyRelationshipRequest;
import com.nhnacademy.resident.domain.dto.response.FamilyRelationshipResidentResponse;
import com.nhnacademy.resident.entity.FamilyRelationship;
import java.util.List;

public interface FamilyRelationshipService {
    FamilyRelationship createFamilyRelationship(FamilyRelationshipRequest familyRelationshipRequest, Long serialNumber);

    List<FamilyRelationship> getFamilyRelationshipList(Long serialNumber);

    FamilyRelationship getFamilyRelationshipBySerialNum(Long serialNum, Long baseNum);

    FamilyRelationship modifyRelationship(ModifyFamilyRelationshipRequest request, Long serialNumber, Long familySerialNumber);

    FamilyRelationship deleteRelationship(Long serialNumber, Long FamilySerialNumber);

    List<FamilyRelationshipResidentResponse> getFamilyRelationshipList2(Long serialNumber);
}
