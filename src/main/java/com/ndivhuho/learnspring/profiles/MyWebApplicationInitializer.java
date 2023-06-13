package com.ndivhuho.learnspring.profiles;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;

@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private final ConfigurableEnvironment configurableEnvironment;

    @Autowired
    public MyWebApplicationInitializer(final ConfigurableEnvironment configurableEnvironment) {
        this.configurableEnvironment = configurableEnvironment;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter(
                "spring.profiles.active", "dev"
        );
    }
}
