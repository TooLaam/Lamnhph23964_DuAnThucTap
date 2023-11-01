package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductDetailResponsitory extends JpaRepository<ProductDetail, UUID> {
    @Query("SELECT a FROM ProductDetail a " +
            "JOIN Product b ON a.product.id = b.id " +
            "WHERE b.id = ?1")
    List<ProductDetail> findByProductId(UUID id);
}
