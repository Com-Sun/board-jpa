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
@Table(name = "birth_death_report_resident")
@Entity
public class BirthDeathReportResident {
    @EmbeddedId
    private Pk pk;

    @Column(name = "birth_death_report_date")
    private LocalDate birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String DeathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Builder(builderClassName = "BirthDeathReportResidentBuilder")
    private BirthDeathReportResident(Pk pk, LocalDate birthDeathReportDate, String phoneNumber) {
        this.pk = pk;
        this.birthDeathReportDate = birthDeathReportDate;
        this.phoneNumber = phoneNumber;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;

        @Column(name = "report_resident_serial_number")
        private Long reportResidentSerialNumber;

        @ManyToOne
        @JoinColumn(name = "resident_serial_number")
        private Resident resident;
    }
}


