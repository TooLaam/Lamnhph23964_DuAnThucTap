package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.service.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public StringToCategoryValueListConverter2 stringToCategoryValueListConverter() {
        return new StringToCategoryValueListConverter2();
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToCategoryValueListConverter());
    }
}
