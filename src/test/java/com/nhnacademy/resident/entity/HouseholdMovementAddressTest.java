package com.nhnacademy.resident.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import java.time.LocalDate;
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
class HouseholdMovementAddressTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void getPkTest() {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(LocalDate.of(2007,10,31), entityManager.find(Household.class, 1L));
        assertThat(entityManager.find(HouseholdMovementAddress.class, pk).getHouseMovementAddress()).isEqualTo("서울시 동작구 상도로 940번길");
    }
}