package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "CartDetail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDetail {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "Cartdetail",referencedColumnName = "Cartid",nullable = true)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "ProductId",referencedColumnName = "Id",nullable = true)
    private Product product;

}
