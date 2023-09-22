package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Category;
import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.service.CategoryService;
import com.example.savis_intern_project.service.ColorService;
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
    private CategoryService service;
    @GetMapping("/index")
    public String hienThi(Model model){
        ArrayList<Category> list = service.getAll();
        model.addAttribute("listCategory",list);
        return "/Category/index";
    }
    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(value = "name") String name
    ){
        service.save(new Category(name));
        return "redirect:/category/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") String id
    ){
        service.delete(UUID.fromString(id));
        return "redirect:/category/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id){
        Optional<Category> loai = service.getOne(UUID.fromString(id));

        model.addAttribute("loai",loai.get());
        return "/Category/update";

    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") String id,
                         @RequestParam("name") String name){
        Category cv = new Category(name);
        service.update(UUID.fromString(id),cv);
        return "redirect:/category/index";
    }
}
