package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BillDetailService {
    void create_new_billdetail(BillDetail billDetail);

    List<BillDetail> get_all_billdetail();

    BillDetail get_one_bill_detail(UUID billDetailId);

//    void change_bill_status(UUID billDetailId);

    void delete_detail(UUID billDetailId);
}
