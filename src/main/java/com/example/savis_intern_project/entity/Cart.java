package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "Cart")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @ManyToOne
    @JoinColumn(name = "CustomerId",referencedColumnName = "Id",nullable = true)
    private Customer customer;

    @Column(name = "Description")
    private String description;
}
