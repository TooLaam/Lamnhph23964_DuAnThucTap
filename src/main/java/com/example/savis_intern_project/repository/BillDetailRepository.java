package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, UUID> {
    @Query("SELECT c from BillDetail c where c.bill.Id = ?1")
    List<BillDetail> getAllByBillId(UUID id);
    @Query("SELECT a FROM BillDetail a " +
            "JOIN Bill b ON a.bill.Id = b.Id " +
            "JOIN ProductDetail c ON a.productDetail.id = c.id " +
            "WHERE b.Id = ?1")
    List<BillDetail> getBillDetailByBillId(UUID id);
}
