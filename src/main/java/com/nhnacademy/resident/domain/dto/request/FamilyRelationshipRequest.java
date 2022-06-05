package com.nhnacademy.resident.domain.dto.request;

import lombok.Data;

@Data
public class FamilyRelationshipRequest {
    private Long familySerialNumber;
    private String relationShip;
}
