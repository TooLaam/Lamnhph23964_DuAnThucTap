package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Employee;
import com.example.savis_intern_project.entity.Role;
import com.example.savis_intern_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("index")
    public String HienThi(Model model) {
        List<Employee> customerList = employeeService.findAll() ;
        model.addAttribute("empList", customerList);

        return "/index/CustomerView";
    }

    @PostMapping("add_employee")
    public String themMoi(Model model,
                          @RequestParam("Id") UUID id,
                          @RequestParam("fullname") String fullname,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("image") String image,
                          @RequestParam("dateOfBirth") String dateOfBirth,
                          @RequestParam("gender") String gender,
                          @RequestParam("datecreated") String datecreated,
                          @RequestParam("phoneNumber") String phoneNumber,
                          @RequestParam("email") String email,
                          @RequestParam("address") String address,
                          @RequestParam("status") String status,
                          @RequestParam("role")Role role
                          ) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFullName(fullname);
        employee.setDateOfBirth(dateOfBirth );
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setDatecreated(datecreated);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setStatus(status);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setImage(image);
        employeeService.add(employee);
        return "redirect:/employee/index";
    }

    @PostMapping("update/{Id}")
    public String update(Model model,
                         @RequestParam("Id") UUID id,
                         @RequestParam("fullname") String fullname,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("image") String image,
                         @RequestParam("dateOfBirth") String dateOfBirth,
                         @RequestParam("gender") String gender,
                         @RequestParam("datecreated") String datecreated,
                         @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         @RequestParam("status") String status,
                         @RequestParam("role")Role role
    ) {
        Employee employee = new Employee();

        employee.setFullName(fullname);
        employee.setDateOfBirth(dateOfBirth );
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setDatecreated(datecreated);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setStatus(status);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setImage(image);

        employeeService.update(id,employee);
        return "redirect:/employee/index";
    }

    @GetMapping("delete/{id}")
    public String Delete(Model model, @PathVariable("id") UUID id) {
        employeeService.delete(id);
        return "redirect:/employee/index";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("ktd", employeeService.detail(id));

        return "detail/employeeDetail";

    }
}
