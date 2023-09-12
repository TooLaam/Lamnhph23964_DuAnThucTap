package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "BillDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class BillDetail {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "Quantity")
    private Integer Quantity;

    @ManyToOne
    @JoinColumn(name = "BillId",referencedColumnName = "Id",nullable = true)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "ProductId",referencedColumnName = "Id",nullable = true)
    private Product product;

}
