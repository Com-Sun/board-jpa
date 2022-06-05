package com.nhnacademy.resident.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import java.time.LocalDateTime;
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
class ResidentEntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void residentEntityTest(){
        Resident resident = entityManager.find(Resident.class, 1L);
        assertThat(resident.getResidentSerialNumber().longValue()).isEqualTo(1L);

        Resident hyunjin = Resident.builder()
            .name("현진")
            .residentSerialNumber(2L)
            .residentRegistrationNumber("12321321")
            .genderCode("남")
            .birthDate(LocalDateTime.now())
            .birthPlaceCode("어딘가")
            .registrationBaseAddress("경기도 어쩌구")
            .build();

        assertThat(hyunjin.getName()).isEqualTo("현진");
    }
}