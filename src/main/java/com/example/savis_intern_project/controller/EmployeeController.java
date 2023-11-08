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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                model.addAttribute("reUsername",username);
                model.addAttribute("rePassword",password);
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
                List<Employee> customerList = employeeService.listDesc() ;
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
            @RequestParam("username1") String username1,
            @RequestParam("password1") String password1,
            @RequestParam("dateOfBirth") String dateOfBirth,
            @RequestParam("gender") int gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("idRole")String idRole,
            Model model,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ) {

        if (fullName.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errName","Invalid Receiver FullName");
            return "/Employee/add";
        }
        if (dateOfBirth.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errDate","Invalid Receiver Date Of Birth");
            return "/Employee/add";
        }
        String Regex = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$";

        if (phoneNumber.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errPhone","Invalid Receiver Phone Number");
            return "/Employee/add";
        }
        if (email.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errEmail","Invalid Receiver Email");
            return "/Employee/add";
        }
        if (address.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errAdd","Invalid Receiver Address");
            return "/Employee/add";
        }
        if (username1.isBlank()){
            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errUser","Invalid Receiver UserName");
            return "/Employee/add";
        }
        if (password1.isBlank()){

            model.addAttribute("role", roleService.getAll());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username,password);
            session.setAttribute("checkRole",employeeService.checkRole(username));
            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin",checkLogin);
            model.addAttribute("fullnameAdd",fullName);
            model.addAttribute("usernameAdd",username1);
            model.addAttribute("passwordAdd",password1);
            model.addAttribute("dateOfBirthAdd",dateOfBirth);
            model.addAttribute("emailAdd",email);
            model.addAttribute("addressAdd",address);
            model.addAttribute("phoneNumberAdd",phoneNumber);
            model.addAttribute("errPass","Invalid Receiver Password");
            return "/Employee/add";
        }
        else {
            List<Employee>  checkUser = employeeService.getByUserName(username1);
            if (!(checkUser.isEmpty())){
                model.addAttribute("role", roleService.getAll());
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username,password);
                session.setAttribute("checkRole",employeeService.checkRole(username));
                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);
                model.addAttribute("fullnameAdd",fullName);
                model.addAttribute("usernameAdd",username1);
                model.addAttribute("passwordAdd",password1);
                model.addAttribute("dateOfBirthAdd",dateOfBirth);
                model.addAttribute("emailAdd",email);
                model.addAttribute("addressAdd",address);
                model.addAttribute("phoneNumberAdd",phoneNumber);
                model.addAttribute("errUserTrung","Duplicate Username !!! Please enter another username");
                return "/Employee/add";
            }


            Employee employee = new Employee();
            Date currentDate = new Date(System.currentTimeMillis());
            Date birth = Date.valueOf(dateOfBirth);
            if (birth.after(currentDate)){
                model.addAttribute("role", roleService.getAll());
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username,password);
                session.setAttribute("checkRole",employeeService.checkRole(username));
                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);
                model.addAttribute("fullnameAdd",fullName);
                model.addAttribute("usernameAdd",username1);
                model.addAttribute("passwordAdd",password1);
                model.addAttribute("dateOfBirthAdd",dateOfBirth);
                model.addAttribute("emailAdd",email);
                model.addAttribute("addressAdd",address);
                model.addAttribute("phoneNumberAdd",phoneNumber);
                model.addAttribute("errDateAfter","Date of birth must be less than current date !!!");
                return "/Employee/add";
            }
            if (!phoneNumber.matches(Regex)){
                model.addAttribute("role", roleService.getAll());
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username,password);
                session.setAttribute("checkRole",employeeService.checkRole(username));
                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);
                model.addAttribute("fullnameAdd",fullName);
                model.addAttribute("usernameAdd",username1);
                model.addAttribute("passwordAdd",password1);
                model.addAttribute("dateOfBirthAdd",dateOfBirth);
                model.addAttribute("emailAdd",email);
                model.addAttribute("addressAdd",address);
                model.addAttribute("phoneNumberAdd",phoneNumber);
                model.addAttribute("errPhoneErrr","Phone number syntax is incorrect !!!");
                return "/Employee/add";
            }


            employee.setFullName(fullName);
            employee.setDateOfBirth(String.valueOf(dateOfBirth) );
            employee.setAddress(address);
            employee.setPhoneNumber(phoneNumber);
            employee.setDatecreated((currentDate));
            employee.setEmail(email);
            employee.setGender(gender);
            employee.setStatus(1);
            employee.setUsername(username1);
            employee.setPassword(password1);
            employee.setRole(roleService.detail(UUID.fromString(idRole)));
            employeeService.add(employee);
            return "redirect:/employee/index";
        }
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
        if (name.isBlank()&&phone.isBlank()) {
            model.addAttribute("empList", employeeService.listDesc());
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Employee checkLogin = employeeService.login(username, password);
            session.setAttribute("checkRole", employeeService.checkRole(username));

            session.setAttribute("Name", checkLogin);
            model.addAttribute("empLogin", checkLogin);

            return "/Employee/index";
        }

        else {
            if (name.isBlank()||phone.isBlank()){
                model.addAttribute("tim",employeeService.timKiem2(name,phone));
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username,password);
                session.setAttribute("checkRole",employeeService.checkRole(username));

                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin",checkLogin);

                return "/Employee/index";
            }
            else {
                model.addAttribute("tim", employeeService.timKiem(name, phone));
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                Employee checkLogin = employeeService.login(username, password);
                session.setAttribute("checkRole", employeeService.checkRole(username));

                session.setAttribute("Name", checkLogin);
                model.addAttribute("empLogin", checkLogin);

                return "/Employee/index";
            }

        }
    }
}
