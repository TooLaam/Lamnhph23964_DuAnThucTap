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
@Table(name = "CategoryDetail")
public class CategoryDetail {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Quantity")
    private Integer Quantity;

    @ManyToOne()
    @JoinColumn(
            name = "ProductId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Product product;

    @ManyToOne()
    @JoinColumn(
            name = "CategoryId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Category category;

    public CategoryDetail(Integer Quantity, Product product, Category category) {

        this.Quantity = Quantity;
        this.product = product;
        this.category = category;
    }
}
