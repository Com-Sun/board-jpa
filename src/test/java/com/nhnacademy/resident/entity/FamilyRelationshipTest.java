package com.nhnacademy.resident.entity;


import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import java.lang.reflect.Member;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
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
class FamilyRelationshipTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void getResidentFromFamilyRelationShipTest() {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(1L, entityManager.find(Resident.class, 2L));
        assertThat(pk.getResident().getName()).isEqualTo("남석환");
    }

    @Test
    void getFamilyRelationshipCodeTest() {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(1L, entityManager.find(Resident.class, 2L));
        FamilyRelationship gildong = entityManager.find(FamilyRelationship.class, pk);
        assertThat(gildong.getFamilyRelationshipCode()).isEqualTo("부");
    }
}