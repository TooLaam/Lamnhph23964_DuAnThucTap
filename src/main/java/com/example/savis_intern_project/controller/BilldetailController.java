package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Bill;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.service.serviceimpl.BillDetailServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Controller
@RequestMapping("/bill_detail")
public class BilldetailController {


    @Autowired
    BillDetailServiceImpl billDetailService;
    @Autowired
    BillServiceImpl billService;

    @GetMapping("/index")
    public String show_data_bill(Model model) {
        model.addAttribute("listBillDetail", billDetailService.get_all_billdetail());
        model.addAttribute("listBill", billService.get_all_bill());
        model.addAttribute("listProduct", "");
        model.addAttribute("view", "/billDetail/index.jsp");
        return "";
    }

    @PostMapping("/create_bill_detail")
    public String create_bill(Model model,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("quantity") Integer quantity,
                              @RequestParam("billId") UUID billId,
                              @RequestParam("productId") UUID productId
    ) {
        BillDetail billDetail = new BillDetail();
        billDetail.setPrice(price);
        billDetail.setQuantity(quantity);
        billDetail.setBill(billService.get_one_bill(billId));
//        billDetail.setProduct(productId);
        billDetailService.create_new_billdetail(billDetail);
        return "redirect:";
    }


    @GetMapping("delete_bill_detail")
    public String delete_bill(Model model, @RequestParam("billDetailId") UUID billDetailId) {
        billDetailService.delete_detail(billDetailId);
        return "";
    }
}
