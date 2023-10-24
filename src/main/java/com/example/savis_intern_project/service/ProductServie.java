package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServie {

    void add(Product product);
    void delete(UUID id);
    void update(UUID id, Product product);
    List<Product> getAll();
    Product getOne(UUID id);
}
