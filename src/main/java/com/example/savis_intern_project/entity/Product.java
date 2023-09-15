package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String descripTion;
    @Column(name = "Manufacturer")
    private String manufacTurer;
    @Column(name = "AvailableQuantity")
    private Integer availableQuantity;
    @Column(name = "sold")
    private Integer sold;
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "Importprice")
    private BigDecimal importPrice;
    @Column(name = "date")
    private Date date;
    @Column(name = "Status")
    private Integer staTus;
    @Column(name = "ImageUrl")
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(
            name = "ColorId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Color color;

    @ManyToOne()
    @JoinColumn(
            name = "CategoryId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Category category;
}
