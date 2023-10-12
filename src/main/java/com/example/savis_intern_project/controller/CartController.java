package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Cart;
import com.example.savis_intern_project.entity.Customer;

import com.example.savis_intern_project.service.CartdetailService;
import com.example.savis_intern_project.service.serviceimpl.CartServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.CartdetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartServiceImpl cartService;

    @Autowired
    CartdetailServiceImpl cartdetailService;

    @PostMapping("/create_cart")
    public String save(Model model,
                              @RequestParam("customerId") Customer customer,
                              @RequestParam("Quantity") Integer Quantity,
                              @RequestParam("TotalMoney") BigDecimal TotalMoney,
                              @RequestParam("Status") Integer Status

    ) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setQuantity(cart.getQuantity());
        cart.setTotalMoney(cart.getTotalMoney());
        cartService.save(cart);

        return "redirect:/cart/index";
    }
    @GetMapping("/index")
    public String show_cart(Model model) {
        model.addAttribute("listCart", cartService.getAll());
        model.addAttribute("listCustomer","");
        model.addAttribute("listDescription",cartdetailService.getAll());
        model.addAttribute("view", "/Cart/index.jsp");
        return "redirect:/cart/index";
    }

    @GetMapping("/indexcus")
    public String show_data_cart_cus(Model model) {
        model.addAttribute("listCart", cartService.getAll());
        model.addAttribute("listCustomer","");
        model.addAttribute("view", "/cart/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/delete-cart")
    public String delete(Model model, @RequestParam("cartId") UUID cartId) {
        cartService.delete(cartId);
        return "redirect:/cart/index";
    }

    @PostMapping("/update-cart")
    public String update(Model model,
                         @PathVariable("CartId") UUID cartId,
                         @PathVariable("CustomerId") UUID customerid,
                         @RequestParam("description") String description){
        cartService.update(cartId,customerid,description);
        return "redirect:/cart/index";
    }
}
