package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CustomerService {
    List<Customer> findAll();
    List<Customer> timKiem(String phone);
    void add(Customer cs);
    void delete(UUID id);
    void update(Customer cs);
    Customer detail(UUID id);
}
