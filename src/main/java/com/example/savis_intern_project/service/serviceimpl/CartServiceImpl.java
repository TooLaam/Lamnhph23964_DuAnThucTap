package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Cart;
import com.example.savis_intern_project.repository.CartRepository;
import com.example.savis_intern_project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository responitory;

    @Override
    public ArrayList<Cart> getAll() {
        return (ArrayList<Cart>) responitory.findAll();
    }

    @Override
    public void save(Cart cart) {
        responitory.saveAndFlush(cart);
    }

    @Override
    public void delete(UUID CartId) {
        responitory.deleteById(CartId);
    }

    @Override
    public void update(UUID CartId, Cart cart) {
        Cart a = getOne(CartId).get();
        a.setQuantity(cart.getQuantity());
        a.setTotalMoney(cart.getTotalMoney());
        a.setStatus(cart.getStatus());
        responitory.flush();

    }

    @Override
    public Optional<Cart> getOne(UUID id) {
        return responitory.findById(id);
    }
}
