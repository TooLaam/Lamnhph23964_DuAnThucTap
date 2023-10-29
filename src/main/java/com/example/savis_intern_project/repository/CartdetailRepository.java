package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.CartDetail;
import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface CartdetailRepository extends JpaRepository<CartDetail, UUID> {

    @Query("SELECT a FROM CartDetail a " +
            "JOIN Cart b ON a.cart.id = b.id " +
            "JOIN ProductDetail c ON a.productDetail.id = c.id " +
            "WHERE b.customer.Id = ?1")
    List<CartDetail> getCartDetailsByCustomerId(UUID customerId);
}
