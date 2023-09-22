package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.FavoriteProducts;
import com.example.savis_intern_project.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FavoriteProductService {
    void add(FavoriteProducts favoriteProducts);
    void delete(UUID id);
    void update(UUID id, FavoriteProducts favoriteProducts);
    List<FavoriteProducts> getAll();
    FavoriteProducts getOne(UUID id);
}
