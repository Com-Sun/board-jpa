package com.nhnacademy.resident.domain.dto.request;

import lombok.Data;

@Data
public class ResidentRegisterRequest {
    private String userId;
    private String pwd;
    private String email;
}
