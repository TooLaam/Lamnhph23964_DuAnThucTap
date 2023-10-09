package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.service.serviceimpl.CategoryServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ColorServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ProductServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class homeController {
    @Autowired
    ColorServiceimpl colorServiceimpl;
    @Autowired
    CategoryServiceimpl categoryServiceimpl;
    @Autowired
    private ProductServiceimpl productServiceimpl;
    @GetMapping("/home" )
    public String home(Model model){
        model.addAttribute("listProduct",productServiceimpl.getAll().subList(0,4));
        model.addAttribute("Product",new Product());
        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("view", "/home/index.jsp");
        return "/customerFE/home/index";
    }


}
