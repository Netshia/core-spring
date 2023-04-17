package com.ndivhuho.learnspring.jdbctemplate.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest

class DatabaseConfigTest {

    @Autowired
    private PropertyDatabaseConfig propertyDatabaseConfig;

    //@Test
    public void whenFactoryProvidedThenYamlPropertiesInjected() {
        assertThat(propertyDatabaseConfig.getDriverClassName()).isEqualTo("org.h2.Driver");
        assertThat(propertyDatabaseConfig.getUrl()).isEqualTo("jdbc:h2:mem:testdb");
        assertThat(propertyDatabaseConfig.getUsername()).isEqualTo("property");
        assertThat(propertyDatabaseConfig.getPassword()).isEqualTo("prop");
    }
}