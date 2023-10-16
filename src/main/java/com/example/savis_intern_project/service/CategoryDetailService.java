package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.CategoryDetail;
import com.example.savis_intern_project.entity.Product;

import java.util.List;
import java.util.UUID;

public interface CategoryDetailService {
    void add(CategoryDetail categoryDetail);
    void delete(UUID id);
    void update(UUID id, CategoryDetail categoryDetail);
    List<CategoryDetail> getAll();
   CategoryDetail getOne(UUID id);
}
