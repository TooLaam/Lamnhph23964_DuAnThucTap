package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.WishList;

import java.util.List;
import java.util.UUID;

public interface WishListService {
    void add(WishList wishList);
    void delete(UUID id);
    void update(UUID id, WishList wishList);
    List<WishList> getAll();
    WishList getOne(UUID id);
}
