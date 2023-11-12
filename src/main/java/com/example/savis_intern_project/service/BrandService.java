package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Brand;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ViewModels.ProductView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface BrandService {

    void add(Brand brand);
    void delete(UUID id);
    void update(UUID id, Brand brand);
    List<Brand> getAll();
    Page<Brand> getAllWithPagination(Pageable pageable);
    Brand getOne(UUID id);

}
