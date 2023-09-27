package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.ProductServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductServie {
    @Autowired ProductResponsitory responsitory;
    @Override
    public void add(Product product) {
     responsitory.saveAndFlush(product);
    }

    @Override
    public void delete(UUID id) {
      responsitory.deleteById(id);
    }

    @Override
    public void update(UUID id, Product product) {
        Product pro = getOne(id);
        pro.setName(product.getName());
        pro.setDescripTion(product.getDescripTion());
        pro.setManufacTurer(product.getManufacTurer());
        pro.setAvailableQuantity(product.getAvailableQuantity());
        pro.setSold(product.getSold());
        pro.setPrice(product.getPrice());
        pro.setImportPrice(product.getImportPrice());
        pro.setDate(product.getDate());
        pro.setStaTus(product.getStaTus());
        pro.setImageUrl(product.getImageUrl());
        pro.setColor(product.getColor());
        pro.setCategory(product.getCategory());
        responsitory.flush();
    }

    @Override
    public List<Product> getAll() {
        return responsitory.findAll();
    }

    @Override
    public Product getOne(UUID id) {

        return responsitory.findById(id).get();
    }
}
