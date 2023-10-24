package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;

import java.util.List;
import java.util.UUID;

public interface ProductDetailService {
    void add(ProductDetail productDetail);
    void delete(UUID id);
    void update(UUID id, ProductDetail productDetail);
    List<ProductDetail> getAll();
    ProductDetail getOne(UUID id);
//    List<ProductDetail> getAnh();
}
