package com.nhnacademy.resident.service;

import com.nhnacademy.resident.domain.dto.request.HouseholdRequest;
import com.nhnacademy.resident.domain.dto.response.HouseholdResponse;

public interface HouseholdService {
    HouseholdResponse createHousehold(HouseholdRequest request);
}
