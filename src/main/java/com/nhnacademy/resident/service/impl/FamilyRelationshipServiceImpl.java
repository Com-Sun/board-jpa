package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.dto.request.FamilyRelationshipRequest;
import com.nhnacademy.resident.domain.dto.request.ModifyFamilyRelationshipRequest;
import com.nhnacademy.resident.domain.dto.response.FamilyRelationshipResidentResponse;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.repository.familyrelationship.FamilyRelationshipRepository;
import com.nhnacademy.resident.service.FamilyRelationshipService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(
        FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public FamilyRelationship createFamilyRelationship(
        FamilyRelationshipRequest familyRelationshipRequest, Long serialNumber) {
        return familyRelationshipRepository.save(FamilyRelationship.builder()
            .pk(new FamilyRelationship.Pk(familyRelationshipRequest.getFamilySerialNumber(), residentRepository.findById(serialNumber).get()))
            .familyRelationshipCode(familyRelationshipRequest.getRelationShip())
            .build());
    }

    @Override
    public List<FamilyRelationship> getFamilyRelationshipList(Long serialNumber) {
        return familyRelationshipRepository.getResidentsHavingResidentSerialNumber(serialNumber);
    }

    @Override
    public FamilyRelationship getFamilyRelationshipBySerialNum(Long serialNum, Long familySerialNum) {
        List<FamilyRelationship> relationships =  familyRelationshipRepository.getResidentsHavingResidentSerialNumber(serialNum);

        return relationships.stream()
            .filter(x -> x.getPk().getFamilyResidentSerialNumber().equals(familySerialNum))
            .collect(Collectors.toList()).get(0);
    }

    @Transactional
    @Override
    public FamilyRelationship modifyRelationship(ModifyFamilyRelationshipRequest request,
                                                 Long serialNumber, Long familySerialNumber) {
        FamilyRelationship familyRelationship = getFamilyRelationshipBySerialNum(serialNumber, familySerialNumber);
        familyRelationship.setFamilyRelationshipCode(request.getFamilyRelationshipCode());
        return familyRelationshipRepository.save(familyRelationship);
    }

    @Transactional
    @Override
    public FamilyRelationship deleteRelationship(Long serialNumber, Long familySerialNumber) {
        FamilyRelationship.Pk pk = getFamilyRelationshipBySerialNum(serialNumber, familySerialNumber).getPk();
        return familyRelationshipRepository.deleteByPk(pk);
    }

    @Override
    public List<FamilyRelationshipResidentResponse> getFamilyRelationshipList2(Long serialNumber) {
        return familyRelationshipRepository.getRelationshipResidentResponsesHavingResidentSerialNumber(serialNumber);
    }

}
