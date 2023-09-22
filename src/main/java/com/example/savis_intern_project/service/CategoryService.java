package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.entity.Color;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    ArrayList<Category> getAll();

    void save(Category category);

    void delete(UUID id);

    void update(UUID id, Category category);

    Optional<Category> getOne(UUID id);
}
