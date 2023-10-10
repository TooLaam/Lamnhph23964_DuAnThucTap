package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.CategoryResponsitory;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.service.CategoryService;
import com.example.savis_intern_project.service.ColorService;
import com.example.savis_intern_project.service.ProductServie;
import com.example.savis_intern_project.service.serviceimpl.CategoryServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ColorServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ProductServiceimpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ColorServiceimpl colorServiceimpl;
    @Autowired
    CategoryServiceimpl categoryServiceimpl;
    @Autowired
    private ProductServiceimpl productServiceimpl;


    @GetMapping("/index")
    public String hienThi(Model model){

        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("Product",new Product());
        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("view", "/Product/index.jsp");
        return "index";
    }

    @GetMapping("/indexcus" )
    public String show_data_product_cus(Model model){

        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("Product",new Product());
        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("view", "/product/index.jsp");
        return "/customerFE/index";
    }

    @PostMapping("/add")
    public String add(Model model,

                      @RequestParam("name") String name,
                      @RequestParam("descripTion") String descripTion,
                      @RequestParam("manufacTurer") String manufacTurer,
                      @RequestParam("availableQuantity") Integer availableQuantity,
                      @RequestParam("sold") Integer sold,
                      @RequestParam("price") BigDecimal price,
                      @RequestParam("importPrice") BigDecimal importPrice,
                      @RequestParam("date") Date date,
                      @RequestParam("staTus") Integer staTus,
                      @RequestParam("imageUrl") String imageUrl,
                      @RequestParam("color") Color color,
                      @RequestParam("category") Category category

    ){
        Product product = new Product(name,descripTion,manufacTurer,availableQuantity,sold,price,importPrice,date,staTus,imageUrl,color,category);
         productServiceimpl.add(product);
        return "redirect:/product/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                          @PathVariable("id") UUID id){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("sp",productServiceimpl.getOne(id));
        model.addAttribute("listColor", colorServiceimpl.getAll());
        model.addAttribute("listCategory", categoryServiceimpl.getAll());
        model.addAttribute("view", "/Product/index.jsp");
        return "index";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam("id") UUID id){
        productServiceimpl.delete(id);
        return "redirect:/product/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("product") Product product){
        productServiceimpl.update(id,product);
        return "redirect:/product/index";
    }
}
