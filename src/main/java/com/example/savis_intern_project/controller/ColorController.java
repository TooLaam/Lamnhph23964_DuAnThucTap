package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Brand;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.BrandResponsitory;
import com.example.savis_intern_project.service.ColorService;
import com.example.savis_intern_project.service.serviceimpl.BrandServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ColorServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorServiceimpl colorServiceimpl;
    @Autowired
    private BrandServiceimpl brandServiceimpl;
    @Autowired
    private BrandResponsitory brandResponsitory;
    @GetMapping("/index")
    public String hienThi(Model model){
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listBrand",brandServiceimpl.getAll());
        model.addAttribute("view", "/Color/index.jsp");
        return "index";
    }
    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(value = "name") String name,
                      @RequestParam(value = "price") BigDecimal price,
                      @RequestParam(value = "image") String image,
                      @RequestParam(value = "status") Integer status,
                      @RequestParam(value = "brand") String brand
    ){
        Brand brand1 = brandResponsitory.findById(UUID.fromString(brand)).orElse(null);
         colorServiceimpl.save(new Color(name,price,image,status,brand1));
        return "redirect:/color/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                      @PathVariable("id") String id
    ){
        colorServiceimpl.delete(UUID.fromString(id));
        return "redirect:/color/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listBrand",brandServiceimpl.getAll());
        model.addAttribute("mau",colorServiceimpl.getOne(id));
        model.addAttribute("view", "/Color/index.jsp");
        return "index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "price") BigDecimal price,
                         @RequestParam(value = "image") String image,
                         @RequestParam(value = "status") Integer status,
                         @RequestParam(value = "brand") String brand){
        Brand brand1 = brandResponsitory.findById(UUID.fromString(brand)).orElse(null);
        Color cv = new Color(name,price,image,status,brand1);
        colorServiceimpl.update(UUID.fromString(id),cv);
        return "redirect:/color/index";
    }
}
