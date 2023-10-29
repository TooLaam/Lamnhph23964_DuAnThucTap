package com.example.savis_intern_project.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductSales {
    private String productName;
    private Integer totalQuantitySold;
    private BigDecimal totalRevenue;

    public ProductSales() {
    }

    public ProductSales(String productName, Integer totalQuantitySold, BigDecimal totalRevenue) {
        this.productName = productName;
        this.totalQuantitySold = totalQuantitySold;
        this.totalRevenue = totalRevenue;
    }

}

