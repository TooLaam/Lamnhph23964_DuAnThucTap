package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PaymentService {
    Payment getOne(UUID uuid);
}
