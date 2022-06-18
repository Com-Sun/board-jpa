package com.nhnacademy.resident.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class HouseholdRequest {
    private Long householdSerialNumber;
    private Long householdResidentSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate householdCompositionDate;
    private String compositionReasonCode;
    private String currentHouseMovementAddress;
}
