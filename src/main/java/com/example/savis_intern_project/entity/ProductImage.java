package com.example.savis_intern_project.entity;


import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "Name")
    private String name;

    @Column(name = "Status")
    private Integer staTus;

    @ManyToOne()
    @JoinColumn(
            name = "ProductDetailId",
            referencedColumnName = "Id",
            nullable = true
    )
    private ProductDetail productDetail;

    public ProductImage( String name, Integer staTus, ProductDetail productDetail) {

        this.name = name;
        this.staTus = staTus;
        this.productDetail = productDetail;
    }
}
