package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    void create_new_bill(Bill bill);

    List<Bill>get_all_bill();
}
