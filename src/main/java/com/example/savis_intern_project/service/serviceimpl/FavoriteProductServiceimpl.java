package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.FavoriteProducts;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.FavoriteProductsRespository;
import com.example.savis_intern_project.service.FavoriteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class FavoriteProductServiceimpl implements FavoriteProductService {
    @Autowired
    FavoriteProductsRespository responitory;

    @Override
    public ArrayList<FavoriteProducts> getAll() {
        return (ArrayList<FavoriteProducts>) responitory.findAll();
    }

    @Override
    public void save(FavoriteProducts favoriteProducts) {
           responitory.saveAndFlush(favoriteProducts);
    }

    @Override
    public void delete(UUID id) {
                   responitory.deleteById(id);
    }

    @Override
    public void update(UUID id, FavoriteProducts favoriteProducts) {
        FavoriteProducts a = getOne(id).get();
        a.setCustomer(favoriteProducts.getCustomer());
        a.setProduct(favoriteProducts.getProduct());
        a.setDescripTion(favoriteProducts.getDescripTion());
        responitory.flush();

    }

    @Override
    public Optional<FavoriteProducts> getOne(UUID id) {
        return responitory.findById(id);
    }
}
