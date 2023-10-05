package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.repository.CustomerRepository;
import com.example.savis_intern_project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> timKiem(String phone) {
        return customerRepository.timKiem(phone);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }




    @Override
    public Customer detail(UUID id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void update(Customer cs) {
       customerRepository.save(cs);

    }

}
