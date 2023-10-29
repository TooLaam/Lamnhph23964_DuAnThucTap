package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.ProductServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductServie {
    @Autowired ProductResponsitory responsitory;
    @Override
    public Product add(Product product) {
        product.setCreatedDate(Date.valueOf(LocalDate.now()));
         return  responsitory.saveAndFlush(product);
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
        pro.setAvailableQuantity(product.getAvailableQuantity());
        pro.setSold(product.getSold());
        pro.setLikes(product.getLikes());
//        pro.setCreatedDate(product.getCreatedDate());
        pro.setStatus(product.getStatus());
        pro.setDescripTion(product.getDescripTion());
        pro.setBrand(product.getBrand());
//        pro.setList(product.getList());
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
