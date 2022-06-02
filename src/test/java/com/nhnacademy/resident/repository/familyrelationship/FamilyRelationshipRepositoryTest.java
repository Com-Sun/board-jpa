package com.nhnacademy.resident.repository.familyrelationship;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import com.nhnacademy.resident.entity.FamilyRelationship;
import com.nhnacademy.resident.entity.Resident;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
class FamilyRelationshipRepositoryTest {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    FamilyRelationshipRepository familyRelationshipRepository;

    @Test
    void queryDslTest() {
        List<FamilyRelationship> residentList =
            familyRelationshipRepository.getResidentsHavingResidentSerialNumber(4L);

        assertThat(residentList.size()).isEqualTo(4);
    }

}