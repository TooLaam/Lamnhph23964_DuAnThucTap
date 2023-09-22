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

    public Product( String name, String descripTion, String manufacTurer, Integer availableQuantity, Integer sold, BigDecimal price, BigDecimal importPrice, Date date, Integer staTus, String imageUrl, Color color, Category category) {

        this.name = name;
        this.descripTion = descripTion;
        this.manufacTurer = manufacTurer;
        this.availableQuantity = availableQuantity;
        this.sold = sold;
        this.price = price;
        this.importPrice = importPrice;
        this.date = date;
        this.staTus = staTus;
        this.imageUrl = imageUrl;
        this.color = color;
        this.category = category;
    }
}
