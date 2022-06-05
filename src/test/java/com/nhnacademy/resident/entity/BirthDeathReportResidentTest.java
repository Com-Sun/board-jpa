package com.nhnacademy.resident.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
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
class BirthDeathReportResidentTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    @DisplayName("기준이의 기석이 출생신고 테스트")
    void birthReportResidentTest() {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk("출생", 4L, entityManager.find(Resident.class, 7L));
        assertThat(pk.getResident().getName()).isEqualTo("남기석");
        assertThat(pk.getReportResidentSerialNumber()).isEqualTo(4L);
    }

}