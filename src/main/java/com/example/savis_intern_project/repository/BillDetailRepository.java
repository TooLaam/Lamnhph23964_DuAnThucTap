package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, UUID> {
    List<BillDetail> getAllByBillId(UUID uuid);
}
