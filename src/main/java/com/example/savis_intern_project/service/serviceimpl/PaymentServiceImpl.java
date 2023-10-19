package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Payment;
import com.example.savis_intern_project.repository.PaymentRepository;
import com.example.savis_intern_project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment getOne(UUID uuid) {
        return paymentRepository.findById(uuid).get();
    }
}
