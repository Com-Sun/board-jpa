package com.nhnacademy.resident.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.resident.entity.Resident;
import java.time.LocalDate;

public interface HouseholdResponse {
    Long getHouseholdSerialNumber();

    Resident getResident();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getHouseholdCompositionDate();

    String getHouseholdCompositionReasonCode();

    String getCurrentHouseMovementAddress();
}
