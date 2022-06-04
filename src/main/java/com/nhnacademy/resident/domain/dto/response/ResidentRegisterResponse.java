package com.nhnacademy.resident.domain.dto.response;

import java.time.LocalDateTime;

public interface ResidentRegisterResponse {
    Long getResidentSerialNumber();
    String getName();
    String getResidentRegistrationNumber();
    String getGenderCode();
    LocalDateTime getBirthDate();
    String getBirthPlaceCode();
    String getRegistrationBaseAddress();

    //Nullable
    LocalDateTime getDeathDate();
    String getDeathPlaceCode();
    String getDeathPlaceAddress();
    String getUserId();
    String getPwd();
    String getEmail();
}
