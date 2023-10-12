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
@Table(name = "ProductDetail")
public class ProductDetail {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ImportPrice")
    private BigDecimal ImportPrice;
    @Column(name = "Price")
    private BigDecimal Price;
    @Column(name = "Quantity")
    private Integer Quantity;
    @Column(name = "CreatedDate")
    private Date CreatedDate;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "Description")
    private String descripTion;

    @ManyToOne()
    @JoinColumn(
            name = "ProductId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Product product;

    @ManyToOne()
    @JoinColumn(
            name = "ColorId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Color color;

    public ProductDetail(BigDecimal ImportPrice, BigDecimal Price, Integer Quantity, Date CreatedDate, Integer Status, String descripTion, Product product, Color color) {

        this.ImportPrice = ImportPrice;
        this.Price = Price;
        this.Quantity = Quantity;
        this.CreatedDate = CreatedDate;
        this.Status = Status;
        this.descripTion = descripTion;
        this.product = product;
        this.color = color;
    }
}
