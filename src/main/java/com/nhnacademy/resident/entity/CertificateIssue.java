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
@Table(name = "certificate_issue")
@Entity
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    private String certificateConfirmationNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private LocalDate certificateIssueDate;

    @Builder(builderClassName = "CertificateIssueBuilder")
    private CertificateIssue(String certificateConfirmationNumber, Resident resident,
                             String certificateTypeCode, LocalDate certificateIssueDate) {
        this.certificateConfirmationNumber = certificateConfirmationNumber;
        this.resident = resident;
        this.certificateTypeCode = certificateTypeCode;
        this.certificateIssueDate = certificateIssueDate;
    }
}
