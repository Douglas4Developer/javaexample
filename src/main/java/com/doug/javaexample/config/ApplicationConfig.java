package com.doug.javaexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

@Configuration
@ComponentScan(basePackages = "com.doug.javaexample")
public class ApplicationConfig {

    @Bean
    public SpringBeanFacesELResolver springBeanFacesELResolver() {
        return new SpringBeanFacesELResolver();
    }
}
