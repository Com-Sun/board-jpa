package com.nhnacademy.resident.config;

import com.nhnacademy.resident.Base;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sys");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(5);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }
}
