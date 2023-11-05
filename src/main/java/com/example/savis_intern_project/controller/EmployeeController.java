package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.entity.Role;
import com.example.savis_intern_project.service.EmployeeService;
import com.example.savis_intern_project.service.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RoleService roleService;

    @GetMapping("/Login")
    public String login(){
        return "login";
    }

    @GetMapping("/indexxx")
    public String indexxx(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username,password);
        session.setAttribute("checkRole",employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin",checkLogin);
        return "index";


    }


    @PostMapping("/loginOK")
    public String loginOK(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          HttpSession session,
                          Model model){
        if (username == ""||password == ""){
            model.addAttribute("erTrong", "Please enter complete information !!!");
            return "login";
        }
        else {
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            if (!(checkLogin == null)){
                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);
                return "index";
            }
            else {
                model.addAttribute("erCheck","Username and password are incorrect");
                return "login";
            }
        }

    }
    @GetMapping("/logout")
    public String loguot(HttpSession session){
        session.removeAttribute("Name");
        return "redirect:/Login";
    }

    @GetMapping("/employee/index")
    public String HienThi(Model model,HttpSession session) {


        if (session.getAttribute("Name") != null){
            if (session.getAttribute("checkRole") == null){
                if (employeeService.findAll().isEmpty()){
                    model.addAttribute("erList","Empty list");
                }
                List<Employee> customerList = employeeService.findAll() ;
                model.addAttribute("empList", customerList);
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username,password);
                session.setAttribute("checkRole",employeeService.checkRole(username));

                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);

                return "/Employee/index";
            }
            else {
                model.addAttribute("erCheckRole","Employees cannot use this function");
                return "login";
            }

        }
        return "login";


    }


    @PostMapping("/employee/update")
    public String updte(Model model,
                        @RequestParam("id") UUID id,
                        @RequestParam("fullName") String fullName,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("dateOfBirth") String dateOfBirth,
                        @RequestParam("gender") int gender,
                        @RequestParam("phoneNumber") String phoneNumber,
                        @RequestParam("email") String email,
                        @RequestParam("address") String address,
                        @RequestParam("status") int status,
                        @RequestParam("idRole")String idRole,
                        HttpSession session
    ) {
        if (session.getAttribute("Name") != null){
            if (session.getAttribute("checkRole") == null){
                Employee employee = new Employee();
                Date currentDate = new Date(System.currentTimeMillis());

                Role rl = roleService.detail(UUID.fromString(idRole));
                employee.setId(id);
                employee.setFullName(fullName);
                employee.setDateOfBirth(dateOfBirth );
                employee.setAddress(address);
                employee.setPhoneNumber(phoneNumber);
                employee.setDatecreated(currentDate);
                employee.setEmail(email);
                employee.setGender(gender);
                employee.setStatus(status);
                employee.setUsername(username);
                employee.setPassword(password);
                employee.setRole(rl);
                employeeService.add(employee);
                return "redirect:/employee/index";
            }
            else {
                model.addAttribute("erCheckRole","Employees cannot use this function");
                return "login";
            }

        }else{
            return "login";
        }


    }

    @PostMapping("/employee/add")
    public String add(
            @RequestParam("fullName") String fullName,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("dateOfBirth") String dateOfBirth,
            @RequestParam("gender") int gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("idRole")String idRole
    ) {

        Employee employee = new Employee();


        Date currentDate = new Date(System.currentTimeMillis());

        employee.setFullName(fullName);
        employee.setDateOfBirth(dateOfBirth );
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setDatecreated((currentDate));
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setStatus(1);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setRole(roleService.detail(UUID.fromString(idRole)));
        employeeService.add(employee);
        return "redirect:/employee/index";
    }


    @GetMapping("/employee/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id,HttpSession session) {
        model.addAttribute("emp", employeeService.detail(id));
        model.addAttribute("role", roleService.getAll());
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username,password);
        session.setAttribute("checkRole",employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin",checkLogin);

        return "/Employee/detail";

    }

    @GetMapping("/employee/viewAdd")
    public String viewAdd(Model model,HttpSession session) {
        model.addAttribute("role", roleService.getAll());
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username,password);
        session.setAttribute("checkRole",employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin",checkLogin);
        return "/Employee/add";

    }

    @GetMapping("/employee/role")
    public String role(Model model) {
        model.addAttribute("role",roleService.getAll());
        return "/Employee/role";

    }

    @GetMapping("/employee/timKiem")
    public String timKiem(Model model,
                          @RequestParam("name1")String name,
                          @RequestParam("phone1")String phone,HttpSession session) {

        if (name ==""||phone==""){
            model.addAttribute("tim",employeeService.timKiem(name,phone));
        }
        if(name ==""&&phone==""){
            model.addAttribute("empList",employeeService.findAll());
        }
        else{
            model.addAttribute("tim",employeeService.timKiem2(name,phone));
        }
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        Employee checkLogin = employeeService.login(username,password);
        session.setAttribute("checkRole",employeeService.checkRole(username));

        session.setAttribute("Name", checkLogin);
        model.addAttribute("empLogin",checkLogin);

        return "/Employee/index";

    }
}
