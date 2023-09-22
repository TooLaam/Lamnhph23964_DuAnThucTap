package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductResponsitory extends JpaRepository<Product,UUID> {
}
