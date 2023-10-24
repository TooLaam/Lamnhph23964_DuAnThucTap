package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Cart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public interface CartService {
    ArrayList<Cart> getAll();

    void save(Cart cart);

    void delete(UUID id);

    void update(UUID id, Cart cart);

    Cart getOne(UUID id);
}
