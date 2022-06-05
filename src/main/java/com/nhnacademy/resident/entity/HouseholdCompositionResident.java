package com.nhnacademy.resident.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "household_composition_resident")
@Entity
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    @Builder
    private HouseholdCompositionResident(Pk pk, LocalDate reportDate,
                                         String householdRelationshipCode,
                                         String householdCompositionChangeReasonCode) {
        this.pk = pk;
        this.reportDate = reportDate;
        this.householdRelationshipCode = householdRelationshipCode;
        this.householdCompositionChangeReasonCode = householdCompositionChangeReasonCode;
    }

    @NoArgsConstructor
    @EqualsAndHashCode
    @AllArgsConstructor
    @Embeddable
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @ManyToOne
        @JoinColumn(name = "household_serial_number")
        private Household household;

        @ManyToOne
        @JoinColumn(name = "resident_serial_number")
        private Resident resident;
    }
}
