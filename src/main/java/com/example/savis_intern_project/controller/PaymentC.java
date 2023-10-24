package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import com.example.savis_intern_project.service.serviceimpl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bill")
public class PaymentC {

    @Autowired
    HttpSession session;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    CartdetailServiceImpl cartDetailService;
    @Autowired
    ProductServiceimpl productService;

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
        if (session.getAttribute("CustomerName") != null) {
            String username = (String) session.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);
            var cart = cartService.getOne(customer.getId());
            var lstCartDetailView = cartDetailService.getCartDetailByCustomerId(customer.getId());
            model.addAttribute("customer", customer);
            model.addAttribute("cart", cart);
            model.addAttribute("cartDetail", lstCartDetailView);
        }
        else{
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
        }
        model.addAttribute("view", "/pay/pay.jsp");
        return "/customerFE/index";
    }

    @PostMapping("/placeorder")
    public String confirm(Model model,
                          @RequestParam("receiverName") String receiverName,
                          @RequestParam("customerPhone") String customerPhone,
                          @RequestParam("PaymentId") UUID PaymentId,
                          @RequestParam("addressDelivery") String addressDelivery,
                          RedirectAttributes redirectAttributes
    ) {
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

        if (session.getAttribute("CustomerName") != null) {
            String username = (String) session.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);
            Cart cart = cartService.getOne(customer.getId());
            ArrayList<CartDetailView> lstCartDetailView = cartDetailService.getCartDetailByCustomerId(customer.getId());

            Date currentDate = new Date(System.currentTimeMillis());

            Bill bill = new Bill();
            bill.setId(UUID.randomUUID());
            bill.setReceiverName(receiverName);
            bill.setTotalMoney(cart.getTotalMoney());
            bill.setCustomerPhone(customerPhone);
            bill.setAddressDelivery(addressDelivery);
            bill.setCreatedDate(currentDate);
            bill.setCustomer(customer);
            bill.setPayment(paymentService.getOne(PaymentId));
            bill.setBillStatus(billStatusService.findById(UUID.fromString("259b8bc3-5489-47c0-a115-b94a0cf6286f")));

            var b = billService.create_new_bill(bill);

            // Tạo danh sách Chi Tiết Hóa Đơn
            for (var lstItem : lstCartDetailView) {
                Product product = productService.getOne(lstItem.getProductId());
                product.setAvailableQuantity(product.getAvailableQuantity() - lstItem.getQuantity());

                BillDetail billDetail = new BillDetail();
                billDetail.setId(UUID.randomUUID());
                billDetail.setQuantity(lstItem.getQuantity());
                billDetail.setPrice(lstItem.getPrice());
                billDetail.setBill(b);
                billDetail.setProductDetail(productDetailServiceimpl.getOne(lstItem.getProductDetailId()));

                // Lưu Chi Tiết Hóa Đơn vào cơ sở dữ liệu
                billDetailService.create_new_billdetail(billDetail);
                productService.update(product.getId(), product);
                cartDetailService.delete(lstItem.getId());
            }
            cart.setQuantity(0);
            cart.setTotalMoney(BigDecimal.ZERO);
            cart.setStatus(1);
            cartService.update(cart.getId(), cart);
            // Truyền tham số qua RedirectAttributes
            redirectAttributes.addAttribute("billId", b.getId());
            return "redirect:/bill/orderComplete/{billId}";
        }
        else {

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
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/orderComplete/{billId}" )
    public String orderComplete(@PathVariable("billId") UUID billId, Model model){
        model.addAttribute("bill", billService.get_one_bill(billId));
        model.addAttribute("billDetail", billDetailService.getByBillId(billId));
        model.addAttribute("view", "/checkout/index.jsp");
        return "/customerFE/index";
    }
}
