package com.example.savis_intern_project.service;


import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Service;

@Service
public interface WebMvcConfigurer {
    public void addFormatters(FormatterRegistry registry);
}
