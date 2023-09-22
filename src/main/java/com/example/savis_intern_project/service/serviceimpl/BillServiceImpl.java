package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillStatus;
import com.example.savis_intern_project.repository.BillRepository;
import com.example.savis_intern_project.repository.BillStatusRepository;
import com.example.savis_intern_project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    BillStatusRepository billStatusRepository;

    @Override
    public void create_new_bill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public List<Bill> get_all_bill() {
        return billRepository.findAll();
    }

    @Override
    public Bill get_one_bill(UUID billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public void change_bill_status(UUID billId) {
        Bill bill = billRepository.findById(billId).get();
        if (bill.getBillStatus().getId() == 1) {
            bill.setBillStatus(billStatusRepository.findById(2).get());
        } else if (bill.getBillStatus().getId() == 2) {
            bill.setBillStatus(billStatusRepository.findById(3).get());
        }
        billRepository.save(bill);

    }

    @Override
    public void delete_bill(UUID billId) {
        billRepository.delete(billRepository.findById(billId).get());
    }
}
