package com.ndivhuho.learnspring.springdata.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class AppConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(String.format("%s Service API", StringUtils.capitalize("Learn Spring")))
                        .version("1.0.0.Final")
                        .description("To up-skill on spring framework")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .email("netshiabiss@gmail.com")
                                .name("Ndivhuho")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        ));
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}