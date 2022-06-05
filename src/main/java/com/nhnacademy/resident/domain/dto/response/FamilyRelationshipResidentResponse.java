package com.nhnacademy.resident.domain.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FamilyRelationshipResidentResponse {
    private String familyRelationshipCode;
    private Long familyResidentSerialNumber;
    private Long residentSerialNumber;
    private String name;
    private String genderCode;
    private LocalDateTime birthDate;
    private String residentRegistrationNumber;
}
