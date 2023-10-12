package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.service.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/favor")
public class FavoriteProductsController {

    @Autowired
    WishListServiceimpl wishListServiceimpl;
    @Autowired
    ProductServiceimpl productServiceimpl;
    @Autowired
    CustomerServiceImpl customerServiceimpl;

    @GetMapping("/index")
    public String hienThi(Model model){

        model.addAttribute("listFavor", wishListServiceimpl.getAll());
        model.addAttribute("FavoriteProducts",new FavoriteProductsController());
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listCustomer",customerServiceimpl.findAll());
        model.addAttribute("view", "/FavoriteProduct/index.jsp");
        return "index";
    }

    @GetMapping("/indexcus" )
    public String show_data_favor_cus(Model model){

        model.addAttribute("listFavor", wishListServiceimpl.getAll());
        model.addAttribute("FavoriteProducts",new Product());
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listCustomer",customerServiceimpl.findAll());
        model.addAttribute("view", "/wishlist/index.jsp");
        return "/customerFE/index";
    }

    @PostMapping("/add")
    public String add(Model model,

                      @RequestParam("customer") Customer customer,
                      @RequestParam("product") Product product


    ){
        WishList wishList = new WishList(customer,product);
        wishListServiceimpl.add(wishList);
        return "redirect:/favor/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        model.addAttribute("listFavor", wishListServiceimpl.getAll());
        model.addAttribute("spyt", wishListServiceimpl.getOne(id));
        model.addAttribute("listCustomer", customerServiceimpl.findAll());
        model.addAttribute("listProduct", productServiceimpl.getAll());
        model.addAttribute("view", "/FavoriteProduct/index.jsp");
        return "index";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam("id") UUID id){
        wishListServiceimpl.delete(id);
        return "redirect:/favor/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("favoriteProducts") WishList wishList){
        wishListServiceimpl.update(id, wishList);
        return "redirect:/favor/index";
    }
}
