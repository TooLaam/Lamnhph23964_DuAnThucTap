package com.example.savis_intern_project.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ProductImage")
public class ProductImage {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @NotBlank(message = "Không được để trống") // Thêm @NotBlank để kiểm tra trường trống
    @Column(name = "Name", unique = true)
    private String name;
    @NotBlank(message = "Không được để trống")
    @Column(name = "Status")
    private Integer staTus;
    @NotBlank(message = "Không được để trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductDetailId" ,referencedColumnName = "Id", nullable = true)
    private ProductDetail productDetail;

    public ProductImage( String name, Integer staTus, ProductDetail productDetail) {

        this.name = name;
        this.staTus = staTus;
        this.productDetail = productDetail;
    }
}
