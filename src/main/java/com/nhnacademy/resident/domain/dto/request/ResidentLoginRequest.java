package com.nhnacademy.resident.domain.dto.request;

import lombok.Data;

@Data
public class ResidentLoginRequest {
    private final String userId;
    private final String pwd;
}
