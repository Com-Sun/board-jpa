package com.nhnacademy.resident.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class HouseholdTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void getCurrentHouseMovementAddressTest() {
        Household household = entityManager.find(Household.class, 1L);
        assertThat(household.getCurrentHouseMovementAddress()).isEqualTo("경기도 성남시 분당구 대왕판교로 645번길");
    }

    @Test
    void getResidentFromHouseholdTest() {
        Household household = entityManager.find(Household.class, 1L);
        assertThat(household.getResident().getName()).isEqualTo("남기준");
    }
}