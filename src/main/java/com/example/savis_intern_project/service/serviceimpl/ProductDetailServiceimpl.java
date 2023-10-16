package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.repository.ProductDetailResponsitory;
import com.example.savis_intern_project.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductDetailServiceimpl implements ProductDetailService {
    @Autowired
    ProductDetailResponsitory responsitory;
    @Override
    public void add(ProductDetail productDetail) {
        responsitory.saveAndFlush(productDetail);
    }

    @Override
    public void delete(UUID id) {
        responsitory.deleteById(id);
    }

    @Override
    public void update(UUID id, ProductDetail productDetail) {
       ProductDetail detail = getOne(id);
       detail.setImportPrice(productDetail.getImportPrice());
        detail.setPrice(productDetail.getPrice());
        detail.setQuantity(productDetail.getQuantity());
        detail.setCreatedDate(productDetail.getCreatedDate());
        detail.setStatus(productDetail.getStatus());
        detail.setDescripTion(productDetail.getDescripTion());
        detail.setProduct(productDetail.getProduct());
        detail.setColor(productDetail.getColor());
        responsitory.flush();
    }

    @Override
    public List<ProductDetail> getAll() {
        return responsitory.findAll();
    }

    @Override
    public ProductDetail getOne(UUID id) {
        return responsitory.findById(id).get();
    }
}
