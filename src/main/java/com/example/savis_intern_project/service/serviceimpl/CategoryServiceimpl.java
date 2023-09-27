package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.repository.CategoryResponsitory;
import com.example.savis_intern_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    CategoryResponsitory responsitory;
    @Override
    public ArrayList<Category> getAll() {
        return (ArrayList<Category>) responsitory.findAll();
    }

    @Override
    public void save(Category category) {
         responsitory.saveAndFlush(category);
    }

    @Override
    public void delete(UUID id) {
         responsitory.deleteById(id);
    }

    @Override
    public void update(UUID id, Category category) {
           Category a = getOne(id);
           a.setName(category.getName());
           responsitory.flush();
    }

    @Override
    public Category getOne(UUID id) {
        return responsitory.findById(id).get();
    }


}
