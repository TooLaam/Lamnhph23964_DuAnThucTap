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
    public void update(UUID id ,Customer cs) {
        Customer customer1 = customerRepository.findById(id).get();
        customer1.setAddress(cs.getAddress());
        customer1.setDateofbirth(cs.getDateofbirth());
        customer1.setEmail(cs.getEmail());
        customer1.setFullname(cs.getFullname());
        customer1.setGender(cs.getGender());
        customer1.setPhone(cs.getPhone());
        customer1.setPassword(cs.getPassword());
        customer1.setUsername(cs.getUsername());
        customer1.setStatus(cs.getStatus());
        this.customerRepository.save(customer1);

    }

}
