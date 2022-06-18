package com.nhnacademy.resident.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface ResidentResponse {
    Long getResidentSerialNumber();
    String getName();
    String getResidentRegistrationNumber();
    String getGenderCode();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime getBirthDate();
    String getBirthPlaceCode();
    String getRegistrationBaseAddress();

    //Nullable
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime getDeathDate();
    String getDeathPlaceCode();
    String getDeathPlaceAddress();
    String getUserId();
    String getPwd();
    String getEmail();
}
