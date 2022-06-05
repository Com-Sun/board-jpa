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
@Table(name = "household_movement_address")
@Entity
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;

    @Column (name = "house_movement_address")
    private String houseMovementAddress;

    @Column (name = "last_address_yn")
    private String lastAddressYn;

    @Builder(builderClassName = "HouseholdMovementAddressBuilder")
    private HouseholdMovementAddress(Pk pk, String houseMovementAddress, String lastAddressYn) {
        this.pk = pk;
        this.houseMovementAddress = houseMovementAddress;
        this.lastAddressYn = lastAddressYn;
    }

    @NoArgsConstructor
    @EqualsAndHashCode
    @AllArgsConstructor
    @Embeddable
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @Column(name = "house_movement_report_date")
        private LocalDate localDate;

        @ManyToOne
        @JoinColumn(name = "household_serial_number")
        private Household household;
    }
}
