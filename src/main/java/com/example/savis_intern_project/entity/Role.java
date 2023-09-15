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
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "RoleName")
    private String roleName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private Integer status;
}
