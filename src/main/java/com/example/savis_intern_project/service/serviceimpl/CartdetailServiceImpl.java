package com.example.savis_intern_project.service.serviceimpl;
import com.example.savis_intern_project.entity.Cart;
import com.example.savis_intern_project.entity.CartDetail;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.CartdetailRepository;
import com.example.savis_intern_project.service.CartdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartdetailServiceImpl implements CartdetailService  {
    @Autowired
    CartdetailRepository responitory;

    @Override
    public ArrayList<CartDetail> getAll() {
        return (ArrayList<CartDetail>) responitory.findAll();
    }

    @Override
    public void save(CartDetail cartdetail)   {
        responitory.saveAndFlush(cartdetail);
    }

    @Override
    public void delete(UUID id)   {
        responitory.deleteById(id);
    }

    @Override
    public void update(UUID id, CartDetail cartdetail) {
        {
            CartDetail a = getOne(id).get();
            a.setQuantity(cartdetail.getQuantity());
            responitory.flush();
        }
    }

    @Override
    public Optional<CartDetail> getOne(UUID id)  {
        return responitory.findById(id);
    }
}
