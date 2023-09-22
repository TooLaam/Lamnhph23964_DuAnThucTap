package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillStatus;
import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.service.serviceimpl.BillServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.BillStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillServiceImpl billService;

    @Autowired
    BillStatusServiceImpl billStatusService;


    @PostMapping("/create_bill")
    public String create_bill(Model model,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("address") String address,
                              @RequestParam("customerId") Customer Customer

    ) {
        Date currentDate = new Date(System.currentTimeMillis());
        Bill bill = new Bill();
        bill.setPrice(price);
        bill.setAddress(address);
        bill.setBillStatus(billStatusService.findById(1));
        bill.setCustomer(Customer);
        bill.setAddress(address);
        bill.setCreateDate(currentDate);
        billService.create_new_bill(bill);

        System.out.println("Ngày hiện tại: " + currentDate);
        return "";
    }

    @GetMapping
    public String show_data_bill(Model model) {
        model.addAttribute("listBill",billService.get_all_bill());
        model.addAttribute("listCustomer","");
        model.addAttribute("listBillStatus",billStatusService.get_all_bill_status());
        model.addAttribute("view", "/bill/index.jsp");
        return "";
    }

    @GetMapping("delete_bill/{billId}")
    public String delete_bill(Model model, @RequestParam("billId") UUID billId) {
        billService.delete_bill(billId);
        return "";
    }

    @PostMapping("/change_bill_status/{billId}")
    public String change_bill_status(Model model, @PathVariable("billId") UUID billId) {
        billService.change_bill_status(billId);
        return "redirect:";
    }
}
