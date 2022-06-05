package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>, FamilyRelationshipCustom{
    @Transactional
    FamilyRelationship deleteByPk(FamilyRelationship.Pk pk);
}
