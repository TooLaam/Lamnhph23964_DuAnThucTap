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
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("index")
    public String HienThi(Model model) {
        List<Customer> customerList = customerService.findAll() ;
        model.addAttribute("cusList", customerList);

        return "/index/CustomerView";
    }

    @PostMapping("add_customer")
    public String themMoi(Model model,
                          @RequestParam("Id") UUID id,
                          @RequestParam("fullname") String fullname,
                          @RequestParam("dateofbirth") String dateofbirth,
                          @RequestParam("address") String address,
                          @RequestParam("phone") String phone,
                          @RequestParam("datecreated") String datecreated,
                          @RequestParam("email") String email,
                          @RequestParam("gender") Boolean gender,
                          @RequestParam("status") Integer status,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password
    ) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFullname(fullname);
        customer.setDateofbirth(Date.valueOf(dateofbirth) );
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDatecreated(datecreated);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(status);
        customer.setUsername(username);
        customer.setPassword(password);
        customerService.add(customer);
        return "redirect:/customer/index";
    }

    @PostMapping("update/{Id}")
    public String update(Model model,
                         @RequestParam("Id") UUID id,
                         @RequestParam("fullname") String fullname,
                         @RequestParam("dateofbirth") String dateofbirth,
                         @RequestParam("address") String address,
                         @RequestParam("phone") String phone,
                         @RequestParam("datecreated") String datecreated,
                         @RequestParam("email") String email,
                         @RequestParam("gender") Boolean gender,
                         @RequestParam("status") Integer status,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password
    ) {
        Customer customer = new Customer();

        customer.setFullname(fullname);
        customer.setDateofbirth(Date.valueOf(dateofbirth) );
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDatecreated(datecreated);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(status);
        customer.setUsername(username);
        customer.setPassword(password);

        customerService.update(id,customer);
        return "redirect:/customer/index";
    }

    @GetMapping("delete/{id}")
    public String Delete(Model model, @PathVariable("id") UUID id) {
        customerService.delete(id);
        return "redirect:/kich_thuoc/hien_thi";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("ktd", customerService.detail(id));

        return "detail/customerDetail";

    }
}
