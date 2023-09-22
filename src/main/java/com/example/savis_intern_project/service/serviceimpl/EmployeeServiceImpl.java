package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.repository.EmployeeRepository;
import com.example.savis_intern_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }




    @Override
    public Employee detail(UUID id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void update(UUID id ,Employee cs) {
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setAddress(cs.getAddress());
        employee1.setDateOfBirth(cs.getDateOfBirth());
        employee1.setEmail(cs.getEmail());
        employee1.setFullName(cs.getFullName());
        employee1.setGender(cs.getGender());
        employee1.setPhoneNumber(cs.getPhoneNumber());
        employee1.setPassword(cs.getPassword());
        employee1.setUsername(cs.getUsername());
        employee1.setStatus(cs.getStatus());
        employee1.setImage(cs.getImage());
        employee1.setRole(cs.getRole());

        this.employeeRepository.save(employee1);

    }
}
