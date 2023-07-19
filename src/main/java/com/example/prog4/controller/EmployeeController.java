package com.example.prog4.controller;


import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.example.prog4.model.RestEmployee;
import com.example.prog4.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;
    private EmployeeMapper mapper;

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/details")
    public String index(@RequestParam("id") String employeeId, Model model) {
        Employee employee = service.getOne(employeeId);
        model.addAttribute("employee", employee);
        return "editProfile";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", RestEmployee.builder().build());
        return "createEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") RestEmployee restEmployee) {
        System.out.println(restEmployee);
        Employee employee = mapper.toDomain(restEmployee);
        service.saveOne(employee);
        return "redirect:/";
    }

}