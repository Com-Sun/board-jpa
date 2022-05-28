package com.nhnacademy.resident.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class FamilyRelationship {
    @Id
    @Column(name = "family_resident_serial_number")
    private Long familyResidentSerialNumber;

    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident resident;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @Builder(builderClassName = "FamilyRelationShipBuilder")
    private FamilyRelationship(Long familyResidentSerialNumber, Resident resident,
                               String familyRelationshipCode) {
        this.familyResidentSerialNumber = familyResidentSerialNumber;
        this.resident = resident;
        this.familyRelationshipCode = familyRelationshipCode;
    }
}
