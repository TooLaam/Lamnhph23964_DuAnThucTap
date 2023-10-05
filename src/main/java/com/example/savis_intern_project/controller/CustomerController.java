package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.repository.CustomerRepository;
import com.example.savis_intern_project.service.CustomerService;
import com.example.savis_intern_project.service.serviceimpl.CustomerServiceImpl;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller

public class CustomerController {


    @Autowired
    CustomerService customerService;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("/customer/index")
    public String HienThi(Model model) {
        List<Customer> customerList = customerService.findAll() ;
        model.addAttribute("cusList", customerService.findAll());

        return "/Customer/index";
    }

    @GetMapping("/customer/viewAdd")
    public String viewAdd(Model model) {
        return "/Customer/add";
    }

    @PostMapping("/customer/add")
    public String themMoi(Model model,

                          @RequestParam("fullname") String fullname,
                          @RequestParam("dateofbirth") String dateofbirth,
                          @RequestParam("address") String address,
                          @RequestParam("phone") String phone,
                          @RequestParam("email") String email,
                          @RequestParam("gender") int gender,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password
    ) {
        Customer customer = new Customer();
        Date currentDate = new Date(System.currentTimeMillis());
        customer.setFullname(fullname);
        customer.setDateofbirth(Date.valueOf(dateofbirth) );
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDatecreated(String.valueOf(currentDate) );
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(1);
        customer.setUsername(username);
        customer.setPassword(password);
        customerService.add(customer);
        return "redirect:/customer/index";
    }

    @PostMapping("/customer/update")
    public String update(Model model,
                         @RequestParam("id") UUID id,
                         @RequestParam("fullname") String fullname,
                         @RequestParam("dateofbirth") String dateofbirth,
                         @RequestParam("address") String address,
                         @RequestParam("phone") String phone,
                         @RequestParam("email") String email,
                         @RequestParam("gender") int gender,
                         @RequestParam("status") Integer status,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password
    ) {
        Customer customer = new Customer();

        customer.setFullname(fullname);
        customer.setDateofbirth(Date.valueOf(dateofbirth) );
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setId(id);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(status);
        customer.setUsername(username);
        customer.setPassword(password);

        customerService.update(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/delete/{id}")
    public String Delete(Model model, @PathVariable("id") UUID id) {
        customerService.delete(id);
        return "redirect:/kich_thuoc/hien_thi";
    }

    @GetMapping("/Customer/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("cus", customerService.detail(id));

        return "/Customer/detail";

    }

    @GetMapping("/Customer/timKiem")
    public String timKiem(Model model,
                          @RequestParam("phone1")String phone) {


        if(phone==""){
            model.addAttribute("cusList",customerService.findAll());
        }
        else{
            model.addAttribute("tim",customerService.timKiem(phone));
        }

        return "/Customer/index";

    }
}
