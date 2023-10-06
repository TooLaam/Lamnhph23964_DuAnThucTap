package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BillService {
    void create_new_bill(Bill bill);

    List<Bill> get_all_bill();
    List<Bill> get_all_byCusId(UUID cusId);

    Bill get_one_bill(UUID billId);

    void change_bill_status(UUID billId);

    void delete_bill(UUID billId);
}
