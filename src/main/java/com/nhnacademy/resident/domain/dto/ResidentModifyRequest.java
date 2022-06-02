package com.nhnacademy.resident.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentModifyRequest {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}
