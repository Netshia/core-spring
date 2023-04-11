package com.ndivhuho.learnspring.jdbctemplate.config;

import com.ndivhuho.learnspring.jdbctemplate.properties.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "db")
@PropertySource(value = "classpath:db/connection.yml", factory = YamlPropertySourceFactory.class)
public class PropertyDatabaseConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
