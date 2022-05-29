package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.FamilyRelationshipRequestDTO;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.repository.FamilyRelationshipRepository;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.service.FamilyRelationshipService;
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
        FamilyRelationshipRequestDTO familyRelationshipRequestDTO, Long serialNumber) {
        return familyRelationshipRepository.save(FamilyRelationship.builder()
            .pk(new FamilyRelationship.Pk(familyRelationshipRequestDTO.getFamilySerialNumber(), residentRepository.findById(serialNumber).get()))
            .familyRelationshipCode(familyRelationshipRequestDTO.getRelationShip())
            .build());
    }
}
