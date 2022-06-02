package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>, FamilyRelationshipCustom{
//    @Query("select Resident FROM Resident WHERE Resident.residentSerialNumber = serialNumber")
//    List<FamilyRelationship> findByPk_Resident(Long serialNumber);

}
