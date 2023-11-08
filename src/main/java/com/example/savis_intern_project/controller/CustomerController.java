package com.example.savis_intern_project.controller;

import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.repository.CustomerRepository;
import com.example.savis_intern_project.service.CustomerService;
import com.example.savis_intern_project.service.EmployeeService;
import com.example.savis_intern_project.service.serviceimpl.CartServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.CartdetailServiceImpl;
import com.example.savis_intern_project.service.serviceimpl.CustomerServiceImpl;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/customer")

public class CustomerController {


    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    CartdetailServiceImpl cartdetailService;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("/index")
    public String HienThi(Model model, HttpSession session, @RequestParam(value = "pageNo",defaultValue = "0")Integer page) {
        if (session.getAttribute("Name") != null) {
            //Nếu đã đăng nhập vào trang index

            model.addAttribute("cusList", customerService.findAll(page));


            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username, password);
            session.setAttribute("checkRole", employeeService.checkRole(username));

            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin", checkLogin);
            model.addAttribute("view", "/Customer/index.jsp");
            return "index";



        }
        //Nếu chưa đăng nhập thì return về trang logina
        return "login";

    }

    @GetMapping("/indexcus")
    public String show_data_customer_cus(Model model, HttpSession session) {
        String username = (String) session.getAttribute("CustomerName");
        String password = (String) session.getAttribute("CustomerPass");
        model.addAttribute("cus", customerService.login(username, password));
        model.addAttribute("cusList", customerService.findAll());
        model.addAttribute("view", "/account/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("view", "/signup/index.jsp");
        return "/customerFE/signup/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("view", "/login/index.jsp");
        return "/customerFE/login/index";
    }

    @PostMapping("/loginOK")
    public String loginOK(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpSession session,
                          Model model) {
        if (username == "" || password == "") {
            model.addAttribute("erTrongCustomer", "Please enter complete information !!!");
            return "/customerFE/login/index";
        } else {
            Customer checkLogin = customerService.login(username, password);
            if (!(checkLogin == null)) {
                session.setAttribute("CustomerName", username);
                session.setAttribute("CustomerPass", password);
                return "redirect:/home";
            } else {
                model.addAttribute("erCheckCustomer", "Username and password are incorrect");
                return "/customerFE/login/index";
            }
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("CustomerName");
        return "redirect:/customer/login";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username, password);
        session.setAttribute("checkRole", employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin", checkLogin);
        model.addAttribute("view", "/Customer/add.jsp");
        return "index";

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
        customer.setDateofbirth(Date.valueOf(dateofbirth));
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDatecreated(String.valueOf(currentDate));
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(1);
        customer.setUsername(username);
        customer.setPassword(password);
        customerService.add(customer);
        Cart cart = new Cart();
        cart.setQuantity(0);
        cart.setTotalMoney(BigDecimal.valueOf(0));
        cart.setTotalMoney(BigDecimal.valueOf(0));
        cart.setCustomer(customer);
        cartService.save(cart);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setPrice(BigDecimal.valueOf(0));
        cartDetail.setQuantity(0);
        cartDetail.setProductDetail(null);
        cartDetail.setCart(cart);
        cartdetailService.save(cartDetail);
        return "redirect:/customer/index";
    }


    @PostMapping("/addLogin")
    public String themMoiLogin(Model model,

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
        customer.setDateofbirth(Date.valueOf(dateofbirth));
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDatecreated(String.valueOf(currentDate));
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(1);
        customer.setUsername(username);
        customer.setPassword(password);
        customerService.add(customer);
        Cart cart = new Cart();
        cart.setId(customer.getId());
        cart.setQuantity(0);
        cart.setTotalMoney(BigDecimal.valueOf(0));
        cart.setTotalMoney(BigDecimal.valueOf(0));
        cart.setCustomer(customer);
        cart.setStatus(0);
        cartService.save(cart);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setPrice(BigDecimal.valueOf(0));
        cartDetail.setQuantity(0);
        cartDetail.setProductDetail(null);
        cartDetail.setCart(cart);
        cartdetailService.save(cartDetail);
        model.addAttribute("sigsUp", "Sign Up Success !!! please log in");
        return "/customerFE/login/index";
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
        customer.setDateofbirth(Date.valueOf(dateofbirth));
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setId(id);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setStatus(status);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setDatecreated(String.valueOf(currentDate));


        customerService.update(customer);
        return "redirect:/customer/index";
    }



    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, HttpSession session) {
        model.addAttribute("cus", customerService.detail(id));
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username, password);
        session.setAttribute("checkRole", employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin", checkLogin);
        model.addAttribute("view", "/Customer/detail.jsp");
        return "index";

    }

    @GetMapping("/timKiem")
    public String timKiem(Model model,
                          @RequestParam("phone1") String phone,
                          HttpSession session,
                          @RequestParam(value = "pageNo",defaultValue = "0")Integer page) {


        if (phone == "") {
            model.addAttribute("cusList", customerService.findAll(page));
        } else {
            model.addAttribute("tim", customerService.timKiem(phone));
        }
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username, password);
        session.setAttribute("checkRole", employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin", checkLogin);
        model.addAttribute("view", "/Customer/index.jsp");
        return "index";

    }
}
