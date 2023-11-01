package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.entity.ProductImage;
import com.example.savis_intern_project.entity.ViewModels.ProductDetailView;
import com.example.savis_intern_project.entity.ViewModels.ProductView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ProductDetailService {
    void add(ProductDetail productDetail);
    void delete(UUID id);
    void update(UUID id, ProductDetail productDetail);
    ArrayList<ProductDetailView> getAllProductDetail();
    ProductDetailView getProductDetailById(UUID id);
    List<ProductDetail> getAll();
    ProductDetail getOne(UUID id);

}
