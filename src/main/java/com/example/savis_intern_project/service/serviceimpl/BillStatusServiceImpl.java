package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.BillStatus;
import com.example.savis_intern_project.repository.BillStatusRepository;
import com.example.savis_intern_project.service.BillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillStatusServiceImpl implements BillStatusService {

    @Autowired
    BillStatusRepository billStatusRepository;

    @Override
    public Bill getBillStatus() {
        return null;
    }

    @Override
    public BillStatus findById(Integer id) {
        return billStatusRepository.findById(id).get();
    }

    @Override
    public List<BillStatus> get_all_bill_status() {
        return billStatusRepository.findAll();
    }
}
