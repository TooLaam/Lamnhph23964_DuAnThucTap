package com.example.savis_intern_project.entity.ViewModels;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.ProductDetail;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BillDetailView {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String ProductName;
    private String ColorName;
    private Integer Quantity;
    private BigDecimal Price;
    private Bill bill;
    private ProductDetail productDetail;
}
