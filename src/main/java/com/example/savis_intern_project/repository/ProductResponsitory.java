package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductResponsitory extends JpaRepository<Product,UUID> {
    @Query("SELECT c from Product c WHERE c.id=?1")
    Product getProductById(UUID id);
}
