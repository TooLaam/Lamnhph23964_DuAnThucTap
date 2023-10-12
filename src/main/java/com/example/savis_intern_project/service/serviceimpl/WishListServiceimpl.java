package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.WishList;
import com.example.savis_intern_project.repository.WishListRespository;
import com.example.savis_intern_project.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishListServiceimpl implements WishListService {
    @Autowired
    WishListRespository responitory;

    @Override
    public void add(WishList wishList) {
         responitory.saveAndFlush(wishList);
    }

    @Override
    public void delete(UUID id) {
    responitory.deleteById(id);
    }

    @Override
    public void update(UUID id, WishList wishList) {
        WishList a = getOne(id);
        a.setCustomer(wishList.getCustomer());
        a.setProduct(wishList.getProduct());
        responitory.flush();
    }

    @Override
    public List<WishList> getAll() {
        return responitory.findAll();
    }

    @Override
    public WishList getOne(UUID id) {
        return responitory.findById(id).get();
    }
}
