package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EmployeeService  {

    List<Employee> findAll();
    void add(Employee cs);
    void delete(UUID id);
    void update(UUID id,Employee cs);
    Employee detail(UUID id);
}
