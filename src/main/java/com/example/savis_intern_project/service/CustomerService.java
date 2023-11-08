package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CustomerService {
    Page<Customer> findAll(Integer pageNo);
    List<Customer> findAll();
    List<Customer> timKiem(String phone);
    void add(Customer cs);
    void delete(UUID id);
    void update(Customer cs);
    Customer detail(UUID id);
    Customer login(String username, String password);
    Customer getCustomerByName(String username);
}
