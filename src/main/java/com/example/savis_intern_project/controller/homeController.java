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
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("Product",new Product());
        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("view", "/home/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blog" )
    public String blog(Model model){
        model.addAttribute("view", "/blog/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blogPage1" )
    public String blogPage1(Model model){
        model.addAttribute("view", "/blogPage1/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blogPage2" )
    public String blogPage2(Model model){
        model.addAttribute("view", "/blogPage2/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blogPage3" )
    public String blogPage3(Model model){
        model.addAttribute("view", "/blogPage3/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blogPage4" )
    public String blogPage4(Model model){
        model.addAttribute("view", "/blogPage4/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/blogPage5" )
    public String blogPage5(Model model){
        model.addAttribute("view", "/blogPage5/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/aboutus" )
    public String aboutUs(Model model){
        model.addAttribute("view", "/aboutus/index.jsp");
        return "/customerFE/index";
    }
}
