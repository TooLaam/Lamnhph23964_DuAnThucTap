package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.BillDetail;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface BillDetailService {
    void create_new_billdetail(BillDetail billDetail);

    List<BillDetail> get_all_billdetail();

    List<BillDetail> get_all_by_billId(UUID billId);

    List<Object[]> get_all_product_sale_by_Date(Date startDate, Date endDate);


    BillDetail get_one_bill_detail(UUID billDetailId);

//    void change_bill_status(UUID billDetailId);

    void delete_detail(UUID billDetailId);
}
