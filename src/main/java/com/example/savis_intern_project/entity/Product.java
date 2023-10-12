package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "AvailableQuantity")
    private Integer availableQuantity;
    @Column(name = "Sold")
    private Integer sold;
    @Column(name = "Likes")
    private Integer Likes;
    @Column(name = "CreatedDate")
    private Date CreatedDate;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "Description")
    private String descripTion;

    @ManyToOne()
    @JoinColumn(
            name = "BrandId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Brand brand;

    public Product( String name, Integer availableQuantity, Integer sold, Integer Likes, Date CreatedDate, Integer Status, String descripTion, Brand brand) {

        this.name = name;
        this.availableQuantity = availableQuantity;
        this.sold = sold;
        this.Likes = Likes;
        this.CreatedDate = CreatedDate;
        this.Status = Status;
        this.descripTion = descripTion;
        this.brand = brand;
    }
}
