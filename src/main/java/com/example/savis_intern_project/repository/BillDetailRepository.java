package com.example.savis_intern_project.repository;


import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.ProductSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, UUID> {
    List<BillDetail> getAllByBillId(UUID uuid);

    @Query("SELECT BD.productDetail.product.name, SUM(BD.Quantity) AS TotalQuantitySold\n" +
            "FROM BillDetail BD\n" +
            "WHERE BD.bill.CreatedDate >= :startDate AND BD.bill.CreatedDate <= :endDate\n" +
            "GROUP BY BD.productDetail.product.name")
    List<Object[]> getProductSalesData(
            @Param("startDate") java.sql.Date startDate,
            @Param("endDate") java.sql.Date endDate);
}
