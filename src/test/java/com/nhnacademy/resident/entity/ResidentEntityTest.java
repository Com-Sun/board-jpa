package com.nhnacademy.resident.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.resident.config.RootConfig;
import com.nhnacademy.resident.config.WebConfig;
import javax.persistence.PersistenceContext;
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

}