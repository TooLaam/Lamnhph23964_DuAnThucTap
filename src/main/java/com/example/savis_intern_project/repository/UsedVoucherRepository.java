package com.example.savis_intern_project.repository;

import com.example.savis_intern_project.entity.UsedVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsedVoucherRepository extends JpaRepository<UsedVoucher, UUID> {
    @Query("SELECT a FROM UsedVoucher a " +
            "JOIN Bill b ON a.bill.Id = b.Id " +
            "JOIN Voucher c ON a.voucher.id = c.id " +
            "WHERE b.Id = :id ")
    UsedVoucher getUsedVoucherByBillId(UUID id);
}
