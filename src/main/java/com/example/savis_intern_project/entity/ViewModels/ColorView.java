package com.example.savis_intern_project.entity.ViewModels;

import com.example.savis_intern_project.entity.Brand;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ColorView {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String name;
    private BigDecimal price;
    private String image;
    private Integer status;
    private UUID productDetailId;
    private Brand brand;
}
