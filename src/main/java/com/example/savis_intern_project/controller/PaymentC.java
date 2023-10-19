package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.service.serviceimpl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bill")
public class PaymentC {

    @Autowired
    HttpSession session;

    @Autowired
    BillStatusServiceImpl billStatusService;

    @Autowired
    BillServiceImpl billService;

    @Autowired
    BillDetailServiceImpl billDetailService;
    @Autowired
    ProductDetailServiceimpl productDetailServiceimpl;
    @Autowired
    PaymentServiceImpl paymentService;

    @GetMapping("/payment")
    public String checkout(Model model) {
        OrderCart cart = (OrderCart) session.getAttribute("OrderCart");
        if (cart == null || cart.getItems().isEmpty()) {
            return "redirect:/viewOrderCart";  // Chuyển hướng người dùng nếu giỏ hàng trống
        }

        ArrayList<Item> list = cart.getItems();
        BigDecimal itemTotal = BigDecimal.ZERO;
        Integer quantity = 0;

        for (Item liItem : list) {
            BigDecimal total;
            total = liItem.getPrice();
            quantity += liItem.getQuantity();
            System.out.println("Total: " + total);
            System.out.println("Quantity: " + quantity);
            model.addAttribute("total", total);
            break;
        }
        model.addAttribute("cartDetail", list);
        model.addAttribute("view", "/pay/pay.jsp");

        return "/customerFE/index";
    }

    @PostMapping("/placeorder")
    public String confirm(Model model,
                          @RequestParam("receiverName") String receiverName,
                          @RequestParam("customerPhone") String customerPhone,
                          @RequestParam("PaymentId") UUID PaymentId,
                          @RequestParam("addressDelivery") String addressDelivery
    ) {
        OrderCart cart = (OrderCart) session.getAttribute("OrderCart");
        if (cart == null || cart.getItems().isEmpty()) {
            return "redirect:/viewOrderCart";  // Chuyển hướng người dùng nếu giỏ hàng trống
        }
        ArrayList<Item> list = cart.getItems();
        BigDecimal totalMoney = BigDecimal.ZERO;

        for (Item liItem : list) {
            totalMoney = liItem.getPrice();
            break;
        }

        if (receiverName.isEmpty()) {
            model.addAttribute("receiverNameError", "Receiver Name is required");
        } else {
            model.addAttribute("inputReceiverName", receiverName);
        }

        if (customerPhone.isEmpty()) {
            model.addAttribute("customerPhoneError", "Customer Phone is required");
        } else {
            model.addAttribute("inputCustomerPhone", customerPhone);
        }

        if (addressDelivery.isEmpty()) {
            model.addAttribute("addressDeliveryError", "Address Delivery is required");
        } else {
            model.addAttribute("inputAddressDelivery", addressDelivery);
        }
        if (addressDelivery.isEmpty()) {
            model.addAttribute("paymentError", "Payment is required");
        } else {
            model.addAttribute("inputPayment", PaymentId);
        }


        if (receiverName.isEmpty() || customerPhone.isEmpty() || addressDelivery.isEmpty()) {
            model.addAttribute("cartDetail", list); // thêm dòng này
            model.addAttribute("total", totalMoney); // và dòng này
            model.addAttribute("view", "/pay/pay.jsp");
            return "/customerFE/index"; // Thay thế bằng tên view của bạn
        }


        Date currentDate = new Date(System.currentTimeMillis());
        Bill bill = new Bill();
        bill.setReceiverName(receiverName);
        bill.setPayment(paymentService.getOne(PaymentId));
        bill.setCustomerPhone(customerPhone);
        bill.setAddressDelivery(addressDelivery);
        bill.setCreatedDate(currentDate);
        bill.setTotalMoney(totalMoney);
        bill.setBillStatus(billStatusService.findById(UUID.fromString("259b8bc3-5489-47c0-a115-b94a0cf6286f")));

        bill = billService.create_new_bill(bill);

// Tạo danh sách Chi Tiết Hóa Đơn
        for (Item liItem : list) {
            BillDetail billDetail = new BillDetail();
            billDetail.setProductDetail(productDetailServiceimpl.getOne(liItem.getIdProduct()));
            billDetail.setQuantity(liItem.getQuantity());
            billDetail.setPrice(liItem.getPrice());
            billDetail.setPrice(liItem.getPrice());
            billDetail.setBill(bill);

            // Lưu Chi Tiết Hóa Đơn vào cơ sở dữ liệu
            billDetailService.create_new_billdetail(billDetail);
        }

        return "redirect:/viewOrderCart";
    }
}
