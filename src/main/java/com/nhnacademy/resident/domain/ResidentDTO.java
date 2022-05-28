package com.nhnacademy.resident.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentDTO {
    Long serialNumber;
    String name;
    String registrationNumber;
    String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate;
    String birthPlace;
    String baseAddress;
}
