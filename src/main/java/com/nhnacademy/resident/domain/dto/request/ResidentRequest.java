package com.nhnacademy.resident.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentRequest {
    private Long serialNumber;
    private String name;
    private String registrationNumber;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;
    private String birthPlace;
    private String baseAddress;
}
