package com.example.savis_intern_project.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "Bill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Bill {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "CreateDate")
    private Date CreateDate;

    @Column(name = "Address")
    private String Address;

    @ManyToOne
    @JoinColumn(name = "BillStatusId",referencedColumnName = "Id",nullable = true)
    private BillStatus billStatus;


    @ManyToOne
    @JoinColumn(name = "EmployeeId",referencedColumnName = "Id",nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "CustomerId",referencedColumnName = "Id",nullable = true)
    private Customer customer;

}
