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
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Status")
    private Integer Status;

    public Category(String Name) {
        this.Name = Name;
    }
}
