package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.repository.BillRepository;
import com.example.savis_intern_project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public void create_new_bill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public List<Bill> get_all_bill() {
        return billRepository.findAll();
    }
}
