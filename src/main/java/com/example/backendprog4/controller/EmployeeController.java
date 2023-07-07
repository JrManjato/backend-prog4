package com.example.backendprog4.controller;

import com.example.backendprog4.modele.Employee;
import com.example.backendprog4.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping(value = "/")
  public String index(HttpSession session, Model model) {
    List<Employee> employees = employeeService.getEmployeesFromSession(session);
    model.addAttribute("employees",employees);
    model.addAttribute("newEmployee", new Employee());
    return "index";
  }

  @PostMapping("/addEmployee")
  public String addEmployee(@ModelAttribute("newEmployee") Employee employee, HttpSession session) {
    List<Employee> employees = employeeService.getEmployeesFromSession(session);
    employees.add(employee);
    session.setAttribute("employees", employees);
    return "redirect:/";
  }
}