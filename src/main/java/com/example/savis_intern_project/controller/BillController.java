package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillStatus;
import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.service.serviceimpl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillServiceImpl billService;


    @PostMapping("/create_bill")
    public String create_bill(Model model,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("address") String address,
                              @RequestParam("billStatusId") BillStatus billStatus,
                              @RequestParam("customerId") Customer Customer

    ) {
        Date currentDate = new Date(System.currentTimeMillis());
        Bill bill = new Bill();
        bill.setPrice(price);
        bill.setAddress(address);
        bill.setBillStatus(billStatus);
        bill.setCustomer(Customer);
        bill.setAddress(address);
        bill.setCreateDate(currentDate);
        billService.create_new_bill(bill);

        System.out.println("Ngày hiện tại: " + currentDate);
        return "";
    }

    @GetMapping
    public String show_data_bill() {
        billService.get_all_bill();
        return "";
    }
}
