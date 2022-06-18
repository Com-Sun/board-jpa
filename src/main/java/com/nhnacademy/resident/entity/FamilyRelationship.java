package com.nhnacademy.resident.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "family_relationship")
@Entity
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident resident;

    @Builder(builderClassName = "FamilyRelationShipBuilder")
    private FamilyRelationship(Pk pk, String familyRelationshipCode) {
        this.pk = pk;
        this.familyRelationshipCode = familyRelationshipCode;
    }

    @NoArgsConstructor
    @EqualsAndHashCode
    @AllArgsConstructor
    @Embeddable
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private Long familyResidentSerialNumber;

        @Column(name = "base_resident_serial_number")
        private Long baseResidentSerialNumber;
    }

}
