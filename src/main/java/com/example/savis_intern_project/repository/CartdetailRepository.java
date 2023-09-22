package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartdetailRepository extends JpaRepository<CartDetail, UUID> {
}
