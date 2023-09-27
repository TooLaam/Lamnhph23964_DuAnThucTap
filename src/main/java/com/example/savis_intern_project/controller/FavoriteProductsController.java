package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.service.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Controller
@RequestMapping("/favor")
public class FavoriteProductsController {

    @Autowired
    FavoriteProductServiceimpl favoriteProductServiceimpl;
    @Autowired
    ProductServiceimpl productServiceimpl;
    @Autowired
    CustomerServiceImpl customerServiceimpl;

    @GetMapping("/index")
    public String hienThi(Model model){

        model.addAttribute("listFavor",favoriteProductServiceimpl.getAll());
        model.addAttribute("FavoriteProducts",new FavoriteProductsController());
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listCustomer",customerServiceimpl.findAll());
        model.addAttribute("view", "/FavoriteProduct/index.jsp");
        return "index";
    }
    @PostMapping("/add")
    public String add(Model model,

                      @RequestParam("customer") Customer customer,
                      @RequestParam("product") Product product,
                      @RequestParam("descripTion") String descripTion


    ){
        FavoriteProducts favoriteProducts = new FavoriteProducts(customer,product,descripTion);
        favoriteProductServiceimpl.add(favoriteProducts);
        return "redirect:/favor/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        model.addAttribute("listFavor",favoriteProductServiceimpl.getAll());
        model.addAttribute("spyt",favoriteProductServiceimpl.getOne(id));
        model.addAttribute("listCustomer", customerServiceimpl.findAll());
        model.addAttribute("listProduct", productServiceimpl.getAll());
        model.addAttribute("view", "/FavoriteProduct/index.jsp");
        return "index";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam("id") UUID id){
        favoriteProductServiceimpl.delete(id);
        return "redirect:/favor/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("favoriteProducts") FavoriteProducts favoriteProducts){
        favoriteProductServiceimpl.update(id,favoriteProducts);
        return "redirect:/favor/index";
    }
}
