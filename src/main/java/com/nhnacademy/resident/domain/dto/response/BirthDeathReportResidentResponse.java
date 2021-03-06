package com.nhnacademy.resident.domain.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BirthDeathReportResidentResponse {
    private String birthDeathTypeCode;
    private Long reportResidentSerialNumber;
    private LocalDate birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String DeathReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
    private Long residentSerialNumber;
    private String name;
    private String deathPlaceCode;
    private String deathPlaceAddress;
    private String residentRegistrationNumber;
    private LocalDateTime deathDate;

}
