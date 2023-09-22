package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorService service;
    @GetMapping("/index")
    public String hienThi(Model model){
        ArrayList<Color> list = service.getAll();
        model.addAttribute("listColor",list);
        return "/Color/index";
    }
    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(value = "name") String name
    ){
         service.save(new Color(name));
        return "redirect:/color/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                      @PathVariable("id") String id
    ){
        service.delete(UUID.fromString(id));
        return "redirect:/color/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id){
        Optional<Color> mau = service.getOne(UUID.fromString(id));

        model.addAttribute("mau",mau.get());
        return "/Color/update";

    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") String id,
                         @RequestParam("name") String name){
        Color cv = new Color(name);
        service.update(UUID.fromString(id),cv);
        return "redirect:/color/index";
    }
}
