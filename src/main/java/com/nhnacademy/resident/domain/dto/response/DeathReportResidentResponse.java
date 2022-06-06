package com.nhnacademy.resident.domain.dto.response;

import lombok.Data;

@Data
public class DeathReportResidentResponse {
    private String name;
    private String residentRegistrationNumber;
    private String birthReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
}
