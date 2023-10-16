package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductImage;

import java.util.List;
import java.util.UUID;

public interface ProductImageService {
    void add(ProductImage productImage);
    void delete(UUID id);
    void update(UUID id, ProductImage productImage);
    List<ProductImage> getAll();
    ProductImage getOne(UUID id);
}
