package com.example.savis_intern_project.repository;

import com.example.savis_intern_project.controller.PaymentC;
import com.example.savis_intern_project.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
