package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.repository.BillDetailRepository;
import com.example.savis_intern_project.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;


    @Override
    public void create_new_billdetail(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }

    @Override
    public List<BillDetail> get_all_billdetail() {
        return billDetailRepository.findAll();
    }
    @Override
    public List<BillDetail> get_all_by_billId(UUID billId) {
        return billDetailRepository.getAllByBillId(billId);
    }


    @Override
    public BillDetail get_one_bill_detail(UUID billDetailId) {
        return billDetailRepository.findById(billDetailId).get();
    }


    @Override
    public void delete_detail(UUID billDetailId) {
        billDetailRepository.deleteById(billDetailId);
    }
}
