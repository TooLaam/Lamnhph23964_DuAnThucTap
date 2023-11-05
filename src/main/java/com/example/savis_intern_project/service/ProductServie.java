package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.entity.ViewModels.ProductView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServie {

    Product add(Product product);
    void delete(UUID id);
    void update(UUID id, Product product);
    ArrayList<ProductView> getAllProduct();
    ArrayList<ProductView> getAllProductByName(String name);
    ArrayList<ProductView> getAllProductByBrand(UUID id);
    List<Product> getAll();
    Product getOne(UUID id);
}
