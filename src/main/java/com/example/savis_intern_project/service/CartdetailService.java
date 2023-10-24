package com.example.savis_intern_project.service;


import com.example.savis_intern_project.entity.CartDetail;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface CartdetailService {
    ArrayList<CartDetail> getAll();
    ArrayList<CartDetailView> getCartDetailByCustomerId(UUID customerId);

    void save(CartDetail cartdetail);

    void delete(UUID id);

    void update(UUID id, CartDetail cartdetail);

    Optional<CartDetail> getOne(UUID id);
}
