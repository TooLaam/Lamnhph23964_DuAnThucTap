package com.example.savis_intern_project.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Color")
public class Color {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "Image")
    private String Image;

    @Column(name = "Status")
    private Integer Status;

    @ManyToOne()
    @JoinColumn(
            name = "BrandId",
            referencedColumnName = "Id",
            nullable = true
    )
    private Brand brand;
}
