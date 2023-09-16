package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "Cart")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @Column(name = "Cartid")
    private UUID Cartid;


    @ManyToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "Id", nullable = true)
    private Customer customer;

    @Column(name = "Description")
    private String description;
}
