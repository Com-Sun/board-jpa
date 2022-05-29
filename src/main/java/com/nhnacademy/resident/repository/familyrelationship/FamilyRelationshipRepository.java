package com.nhnacademy.resident.repository.familyrelationship;

import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>, FamilyRelationshipCustom{
//    @Query("select Resident FROM Resident WHERE Resident.residentSerialNumber = serialNumber")
//    List<FamilyRelationship> findByPk_Resident(Long serialNumber);

}
