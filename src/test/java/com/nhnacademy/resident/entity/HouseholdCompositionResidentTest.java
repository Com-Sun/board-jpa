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
class HouseholdCompositionResidentTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void getPk() {
        HouseholdCompositionResident.Pk pk = new HouseholdCompositionResident.Pk(entityManager.find(Household.class, 1L), entityManager.find(Resident.class, 4L));
        assertThat(entityManager.find(HouseholdCompositionResident.class, pk).getPk()).isEqualTo(pk);
        assertThat(entityManager.find(HouseholdCompositionResident.class, pk).getReportDate()).isEqualTo(
            LocalDate.of(2009,10,02));
    }
}