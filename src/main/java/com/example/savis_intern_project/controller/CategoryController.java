package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.service.CategoryService;
import com.example.savis_intern_project.service.ColorService;
import com.example.savis_intern_project.service.serviceimpl.CategoryServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceimpl categoryServiceimpl;
    @GetMapping("/index")
    public String hienThi(Model model){
        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("view", "/Category/index.jsp");
        return "index";
    }
    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(value = "name") String name,
                      @RequestParam(value = "status") Integer status
    ){
        categoryServiceimpl.save(new Category(name,status));
        return "redirect:/category/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") String id
    ){
        categoryServiceimpl.delete(UUID.fromString(id));
        return "redirect:/category/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){

        model.addAttribute("listCategory",categoryServiceimpl.getAll());
        model.addAttribute("loai",categoryServiceimpl.getOne(id));
        model.addAttribute("view", "/Category/index.jsp");
        return "index";

    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("status") Integer status){
        Category cv = new Category(name,status);
        categoryServiceimpl.update(UUID.fromString(id),cv);
        return "redirect:/category/index";
    }
}
