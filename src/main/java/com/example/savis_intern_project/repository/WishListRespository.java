package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WishListRespository extends JpaRepository<WishList, UUID> {
}
