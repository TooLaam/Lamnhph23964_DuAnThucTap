package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.service.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillServiceImpl billService;
    @Autowired
    BillDetailServiceImpl billDetailService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    BillStatusServiceImpl billStatusService;


    @PostMapping("/create_bill")
    public String create_bill(Model model,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("address") String address,
                              @RequestParam("customerId") UUID Customer,
                              @RequestParam("employeeId") UUID Employee

    ) {
        Date currentDate = new Date(System.currentTimeMillis());
        Bill bill = new Bill();
        bill.setPrice(price);
        bill.setAddress(address);
        bill.setBillStatus(billStatusService.findById(1));
        bill.setCustomer(customerService.detail(Customer));
        bill.setEmployee(employeeService.detail(Employee));
        bill.setAddress(address);
        bill.setCreateDate(currentDate);


        billService.create_new_bill(bill);

        System.out.println("Ngày hiện tại: " + currentDate);
        return "redirect:/bill/index";
    }

    @PostMapping("/update-bill/{billId}")
    public String update_bill(Model model,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("address") String address,
                              @RequestParam("customerId") UUID Customer,
                              @RequestParam("employeeId") UUID Employee,
                              @PathVariable("billId") UUID billId

    ) {
        Date currentDate = new Date(System.currentTimeMillis());
        Bill bill = billService.get_one_bill(billId);
        bill.setPrice(price);
        bill.setAddress(address);
        bill.setBillStatus(billStatusService.findById(1));
        bill.setCustomer(customerService.detail(Customer));
        bill.setEmployee(employeeService.detail(Employee));
        bill.setAddress(address);
        bill.setCreateDate(currentDate);
        billService.create_new_bill(bill);

        System.out.println("Ngày hiện tại: " + currentDate);
        return "redirect:/bill/index";
    }

    @GetMapping("/index")
    public String show_data_bill(Model model) {
        model.addAttribute("listBill", billService.get_all_bill());
        model.addAttribute("listCustomer", customerService.findAll());
        model.addAttribute("listEmployee", employeeService.findAll());
        model.addAttribute("listBillStatus", billStatusService.get_all_bill_status());
        model.addAttribute("view", "/Bill/index.jsp");
        return "index";
    }

    @GetMapping("/indexcus/{idCus}")
    public String show_data_bill_cus(Model model,@PathVariable("idCus")UUID idCus) {

        model.addAttribute("listBill", billService.get_all_byCusId(idCus));
//        model.addAttribute("listCustomer", customerService.findAll());
//        model.addAttribute("listEmployee", employeeService.findAll());
//        model.addAttribute("listBillStatus", billStatusService.get_all_bill_status());
//        model.addAttribute("view", "/Bill/index.jsp");
        return "/customerFE/bill/index";
    }

    @GetMapping("/index/{billId}")
    public String show_data_bill(Model model, @PathVariable("billId") UUID billId) {
        model.addAttribute("listBill", billService.get_all_bill());
        model.addAttribute("listCustomer", customerService.findAll());
        model.addAttribute("listEmployee", employeeService.findAll());
        model.addAttribute("listBillStatus", billStatusService.get_all_bill_status());
        model.addAttribute("billD", billService.get_one_bill(billId));
        List<BillDetail> billDetailList = billDetailService.get_all_by_billId(billId);
        double allPrice = 0; // Khởi tạo biến tổng giá trị hóa đơn
        for (BillDetail billDetail : billDetailList) {
            int quantity = billDetail.getQuantity();
            BigDecimal price = billDetail.getProduct().getPrice();
            BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));
            allPrice = allPrice + totalPrice.doubleValue();
        }

        System.out.println(allPrice);
        model.addAttribute("billDetailD", billDetailList);
        model.addAttribute("allPrice", allPrice);


        model.addAttribute("view", "/Bill/index.jsp");
        return "index";
    }

    @GetMapping("delete_bill/{billId}")
    public String delete_bill(Model model, @PathVariable("billId") UUID billId) {
        billService.delete_bill(billId);
        return "redirect:/bill/index";
    }

    @PostMapping("change_bill_status/{billId}")
    public String change_bill_status(Model model, @PathVariable("billId") UUID billId) {
        billService.change_bill_status(billId);
        return "redirect:/bill/index";
    }
}
