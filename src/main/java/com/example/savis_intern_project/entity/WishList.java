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
@Table(name = "WishList")
public class WishList {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(
            name = "CustomerId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Customer customer;

    @ManyToOne()
    @JoinColumn(
            name = "ProductId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Product product;

    public WishList(Customer customer, Product product) {

        this.customer = customer;
        this.product = product;
    }
}
