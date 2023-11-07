package com.example.savis_intern_project.repository;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, UUID> {
    @Query("SELECT a FROM Voucher a " +
            "WHERE a.code LIKE :code ")
    Voucher findByVoucherCode(String code);
}
