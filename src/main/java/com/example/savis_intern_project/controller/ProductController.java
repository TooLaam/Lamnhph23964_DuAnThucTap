package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Brand;
import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.BrandResponsitory;
import com.example.savis_intern_project.repository.CategoryResponsitory;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.service.CategoryService;
import com.example.savis_intern_project.service.ColorService;
import com.example.savis_intern_project.service.ProductServie;
import com.example.savis_intern_project.service.serviceimpl.*;
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
    private ProductServiceimpl productServiceimpl;
    @Autowired
    private BrandServiceimpl brandServiceimpl;
    @Autowired
    private CategoryDetailServiceimpl categoryDetailServiceimpl;
    @Autowired
    private BrandResponsitory responsitory;
    @GetMapping("/index")
    public String hienThi(Model model){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listBrand",brandServiceimpl.getAll());
        model.addAttribute("listCategoryDetail",categoryDetailServiceimpl.getAll());
        model.addAttribute("Product",new Product());
        model.addAttribute("view", "/Product/index.jsp");
        return "index";
    }

//    @GetMapping("/index1" )
//    public String show_data_product_cus(Model model){
//
//        model.addAttribute("listProduct",productServiceimpl.getAll());
//        model.addAttribute("Product",new Product());
//        model.addAttribute("listCategory",categoryServiceimpl.getAll());
//        model.addAttribute("listColor",colorServiceimpl.getAll());
//        model.addAttribute("view", "/product/index.jsp");
//        return "/customerFE/index";
//    }

//    @PostMapping("/add")
//    public String add(Model model,
//                      @RequestParam("name") String name,
//                      @RequestParam("availableQuantity") Integer availableQuantity,
//                      @RequestParam("sold") Integer sold,
//                      @RequestParam("likes") Integer likes,
//                      @RequestParam("createdDate") Date createdDate,
//                      @RequestParam("status") Integer status,
//                      @RequestParam("descripTion") String descripTion,
//                      @RequestParam("brand")String brand
//                      ){
//         Brand brand1 = responsitory.findById(UUID.fromString(brand)).orElse(null);
//         Product product = new Product(name,availableQuantity,sold,likes,createdDate,status,descripTion,brand1);
//         productServiceimpl.add(product);
//        return "redirect:/product/index";
//    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                          @PathVariable("id") UUID id){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listBrand",brandServiceimpl.getAll());
        model.addAttribute("sp",productServiceimpl.getOne(id));
        model.addAttribute("view", "/Product/index.jsp");
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") UUID id){
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
