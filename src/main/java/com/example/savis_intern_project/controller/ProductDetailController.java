package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Brand;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.repository.BrandResponsitory;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.serviceimpl.BrandServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ColorServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ProductDetailServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ProductServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Controller
@RequestMapping("/product_detail")
public class ProductDetailController {
    @Autowired
    private ProductServiceimpl productServiceimpl;
    @Autowired
    private ColorServiceimpl colorServiceimpl;
    @Autowired
    private ProductDetailServiceimpl productDetailServiceimpl;
    @Autowired
    private ProductResponsitory productResponsitory;
    @Autowired
    private ColorResponsitory colorResponsitory;
    @GetMapping("/index")
    public String hienThi(Model model){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listProductDetail",productDetailServiceimpl.getAll());
        model.addAttribute("ProductDetail",new ProductDetail());
        model.addAttribute("view", "/ProductDetail/index.jsp");
        return "index";
    }

//    @GetMapping("/indexcus" )
//    public String show_data_product_cus(Model model){
//
//        model.addAttribute("listProduct",productServiceimpl.getAll());
//        model.addAttribute("Product",new Product());
//        model.addAttribute("listCategory",categoryServiceimpl.getAll());
//        model.addAttribute("listColor",colorServiceimpl.getAll());
//        model.addAttribute("view", "/product/index.jsp");
//        return "/customerFE/index";
//    }

    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam("importPrice") BigDecimal importPrice,
                      @RequestParam("price") BigDecimal price,
                      @RequestParam("quantity") Integer quantity,
                      @RequestParam("createdDate") Date createdDate,
                      @RequestParam("descripTion") String descripTion,
                      @RequestParam("status") Integer status,
                      @RequestParam("product") String product,
                      @RequestParam("color")String color
    ){

        Product product1 = productResponsitory.findById(UUID.fromString(product)).orElse(null);
        Color color1 = colorResponsitory.findById(UUID.fromString(color)).orElse(null);
        ProductDetail productDetail = new ProductDetail(importPrice,price,quantity,createdDate,status,descripTion,product1,color1);
        productDetailServiceimpl.add(productDetail);
        System.out.println(productDetail.toString());
        return "redirect:/product_detail/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listProductDetail",productDetailServiceimpl.getAll());
        model.addAttribute("detailSP",productDetailServiceimpl.getOne(id));
        model.addAttribute("view", "/ProductDetail/index.jsp");
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") UUID id){
        productDetailServiceimpl.delete(id);
        return "redirect:/product_detail/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("productDetail") ProductDetail productDetail){
       productDetailServiceimpl.update(id,productDetail);
        return "redirect:/product_detail/index";
    }
}
