package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillRepository extends JpaRepository<Bill, UUID> {
    @Query("SELECT c from Bill c where c.customer.Id = ?1")
    List<Bill>getAllByCustomerId(UUID cusId);
}
