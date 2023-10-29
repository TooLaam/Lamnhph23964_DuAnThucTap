package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.Product;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface BillService {
    Bill create_new_bill(Bill bill);

    Bill update_bill(Bill bill);

    List<Bill> get_all_bill();

    List<Bill> get_all_byCusId(UUID cusId);

    List<Bill> get_all_by_Date(Date startDate, Date endDate);

    Bill get_one_bill(UUID billId);

    void change_bill_status(UUID billId);

    void delete_bill(UUID billId);
}
