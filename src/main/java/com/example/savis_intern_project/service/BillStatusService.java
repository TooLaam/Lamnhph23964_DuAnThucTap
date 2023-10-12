package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.BillStatus;

import java.util.List;
import java.util.UUID;

public interface BillStatusService {
    Bill getBillStatus();

    BillStatus findById(UUID id);

    List<BillStatus> get_all_bill_status();
}
