package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.service.serviceimpl.CategoryServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ColorServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.FavoriteProductServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favor")
public class FavoriteProductsController {

    @Autowired
    FavoriteProductServiceimpl favoriteProductServiceimpl;
    @Autowired
    ColorServiceimpl colorServiceimpl;
    @Autowired
    CategoryServiceimpl categoryServiceimpl;
}
