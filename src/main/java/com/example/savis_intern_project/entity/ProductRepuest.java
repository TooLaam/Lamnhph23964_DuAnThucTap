package com.example.savis_intern_project.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductRepuest {

    private List<String> files;
    private BigDecimal importPrice;
    private BigDecimal price;
    private Integer quantity;
    private Date createdDate;
    private Integer status;
    private String descripTion;
    private UUID color;
    private UUID product;
}
