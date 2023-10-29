package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.CategoryValue;

import java.util.List;

public interface Converter {
    List<CategoryValue> convert(String source);
}
