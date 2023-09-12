package com.example.savis_intern_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Bill_Status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class BillStatus {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Name")
    private String Name;
}
