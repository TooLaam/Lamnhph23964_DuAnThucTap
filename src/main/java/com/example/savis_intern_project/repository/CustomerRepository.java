package com.example.savis_intern_project.repository;

import com.example.savis_intern_project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,UUID> {
}
