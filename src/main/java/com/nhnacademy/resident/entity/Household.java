package com.nhnacademy.resident.entity;

import java.time.LocalDate;
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
@Table(name = "household")
@Entity
public class Household {
    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @Column(name = "household_composition_date")
    private LocalDate householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @Builder(builderClassName = "HouseholdBuilder")
    private Household(Long householdSerialNumber, Resident resident,
                      LocalDate householdCompositionDate, String householdCompositionReasonCode,
                      String currentHouseMovementAddress) {

        this.householdSerialNumber = householdSerialNumber;
        this.resident = resident;
        this.householdCompositionDate = householdCompositionDate;
        this.householdCompositionReasonCode = householdCompositionReasonCode;
        this.currentHouseMovementAddress = currentHouseMovementAddress;
    }
}
