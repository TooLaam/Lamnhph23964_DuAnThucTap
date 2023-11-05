package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.ViewModels.WishListView;
import com.example.savis_intern_project.entity.WishList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface WishListService {
    void add(WishList wishList);
    void delete(UUID id);
    void update(UUID id, WishList wishList);
    void Like(UUID customerId, UUID productDetailId);
    List<WishList> getAll();
    ArrayList<WishListView> getAllByCustomerId(UUID id);
    WishList getOne(UUID id);
}
