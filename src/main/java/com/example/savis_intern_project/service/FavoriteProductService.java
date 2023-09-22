package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.FavoriteProducts;
import com.example.savis_intern_project.entity.Product;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface FavoriteProductService {
    ArrayList<FavoriteProducts> getAll();

    void save(FavoriteProducts favoriteProducts);

    void delete(UUID id);

    void update(UUID id, FavoriteProducts favoriteProducts);

    Optional<FavoriteProducts> getOne(UUID id);
}
