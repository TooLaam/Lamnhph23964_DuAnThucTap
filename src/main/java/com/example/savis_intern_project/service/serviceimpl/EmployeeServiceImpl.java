package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.repository.EmployeeRepository;
import com.example.savis_intern_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
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
    public List<Employee> timKiem(String name, String phone) {
        return employeeRepository.timKiem(name,phone);
    }

    @Override
    public List<Employee> timKiem2(String name, String phone) {
        return employeeRepository.timKiem2(name,phone);
    }

    @Override
    public void update(Employee cs) {

        this.employeeRepository.save(cs);

    }
}
