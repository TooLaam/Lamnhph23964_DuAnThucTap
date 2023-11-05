package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.Customer;
import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.repository.CustomerRepository;
import com.example.savis_intern_project.service.CustomerService;
import com.example.savis_intern_project.service.serviceimpl.CustomerServiceImpl;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/customer")

public class CustomerController {


    @Autowired
    CustomerService customerService;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("/index")
    public String HienThi(Model model, HttpSession session) {
        if (session.getAttribute("Name") != null){
            //Nếu đã đăng nhập vào trang index
            List<Customer> customerList = customerService.findAll() ;
            model.addAttribute("cusList", customerService.findAll());

            return "/Customer/index";
        }
        //Nếu chưa đăng nhập thì return về trang login
        return "login";

    }

    @GetMapping("/indexcus" )
    public String show_data_customer_cus(Model model){
        model.addAttribute("cusList",customerService.findAll());
        model.addAttribute("view", "/account/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/signup" )
    public String signup(Model model){
        model.addAttribute("view", "/signup/index.jsp");
        return "/customerFE/signup/index";
    }

    @GetMapping("/login" )
    public String login(Model model){
        model.addAttribute("view", "/login/index.jsp");
        return "/customerFE/login/index";
    }

    @PostMapping("/loginOK")
    public String loginOK(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          HttpSession session,
                          Model model){
        if (username == ""||password == ""){
            model.addAttribute("erTrongCustomer", "Please enter complete information !!!");
            return "/customerFE/login/index";
        }
        else {
            Customer checkLogin = customerService.login(username,password);
            if (!(checkLogin == null)){
                session.setAttribute("CustomerName", username);
                return "redirect:/home";
            }
            else {
                model.addAttribute("erCheckCustomer","Username and password are incorrect");
                return "/customerFE/login/index";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("CustomerName");
        return "redirect:/customer/login";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model) {
        return "/Customer/add";
    }

    @PostMapping("/add")
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

    @PostMapping("/update")
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
        Date currentDate = new Date(System.currentTimeMillis());
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

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("cus", customerService.detail(id));

        return "/Customer/detail";

    }

    @GetMapping("/timKiem")
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
