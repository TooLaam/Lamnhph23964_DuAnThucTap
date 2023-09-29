package com.example.savis_intern_project.controller;
import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.CartDetail;
import com.example.savis_intern_project.service.serviceimpl.CartServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.CartdetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/cart-detail")
public class CartdetailController {
    @Autowired
    CartdetailServiceImpl cartdetailService;
    @Autowired
    CartServiceImpl cartService;

    @GetMapping("/index")
    public String show_data_cart(Model model) {
        model.addAttribute("listCartDetail", cartdetailService.getAll());
        model.addAttribute("listCart", cartService.getAll());
        model.addAttribute("listProduct", "");
        model.addAttribute("listQuantity", cartdetailService.getAll());
        model.addAttribute("view", "/CartDetail/index.jsp");
        return "redirect:/cart/index";
    }
    @PostMapping("/create_cart_detail")
    public String create_cart(Model model,
                              @RequestParam("Cartdetail") UUID cartdetailid,
                              @RequestParam("ProductId") UUID productid,
                              @RequestParam("Quantity") Integer quantity
    ) {
       CartDetail cartDetail = new CartDetail();
        cartDetail.setQuantity(quantity);
       // cartDetail.setProduct(productid);
//        billDetail.setProduct(productId);
        cartdetailService.save(cartDetail);
        return "redirect:/cart/index";
    }


    @GetMapping("delete_cart_detail")
    public String delete_cart(Model model, @RequestParam("CartDetailId") UUID cartdetailid) {
        cartdetailService.delete(cartdetailid);
        return "redirect:/cart/index";
    }
}
