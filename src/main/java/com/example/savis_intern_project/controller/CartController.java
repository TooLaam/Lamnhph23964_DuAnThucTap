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
                              @RequestParam("description") String description

    ) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setDescription(description);
        cartService.save(cart);

        return "";
    }
    @GetMapping
    public String show_cart(Model model) {
        model.addAttribute("listCart", cartService.getAll());
        model.addAttribute("listCustomer","");
        model.addAttribute("listDescription",cartdetailService.getAll());
        model.addAttribute("view", "/cart/index.jsp");
        return "";
    }
    @GetMapping("delete-cart")
    public String delete(Model model, @RequestParam("cartId") UUID cartId) {
        cartService.delete(cartId);
        return "";
    }

    @PostMapping("/update-cart")
    public String update(Model model,
                         @PathVariable("CartId") UUID cartId,
                         @PathVariable("CustomerId") UUID customerid,
                         @RequestParam("description") String description){
        cartService.update(cartId,customerid,description);
        return "redirect:/color/index";
    }
}
