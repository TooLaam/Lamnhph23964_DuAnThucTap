package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Brand;
import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.service.EmployeeService;
import com.example.savis_intern_project.service.serviceimpl.BrandServiceimpl;
import com.example.savis_intern_project.service.serviceimpl.ProductServiceimpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.UUID;

@Controller
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private BrandServiceimpl serviceimpl;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/index")
    public String hienThi(Model model, HttpSession session){
        if (session.getAttribute("Name") != null){
            //Nếu đã đăng nhập vào trang index
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            model.addAttribute("empLogin",checkLogin);
            //////
            model.addAttribute("listBrand",serviceimpl.getAll());
            model.addAttribute("Brand",new Brand());
            model.addAttribute("view", "/Brand/index.jsp");
            return "index";
        }
        //Nếu chưa đăng nhập thì return về trang logina
        return "login";

    }

    @GetMapping("/indexcus" )
    public String show_data_product_cus(Model model){
        model.addAttribute("listBrand",serviceimpl.getAll());
        model.addAttribute("quantityBrand",serviceimpl.getAll().size());
        model.addAttribute("view", "/brand/index.jsp");
        return "/customerFE/index";
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
                      @RequestParam("name") String name,
                      @RequestParam("image") String image,
                      @RequestParam("staTus") Integer staTus
    ){
        Brand brand = new Brand(name,image,staTus);
        serviceimpl.add(brand);
        return "redirect:/brand/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        model.addAttribute("listBrand",serviceimpl.getAll());
        model.addAttribute("bra",serviceimpl.getOne(id));
        model.addAttribute("view", "/Brand/index.jsp");
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") UUID id){
        serviceimpl.delete(id);
        return "redirect:/brand/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("brand") Brand brand){
        serviceimpl.update(id,brand);
        return "redirect:/brand/index";
    }
}
