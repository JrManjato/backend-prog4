package com.example.prog4.controller;


import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.model.EditEmployee;
import com.example.prog4.model.Employee;
import com.example.prog4.model.ShowEmployee;
import com.example.prog4.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
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
    model.addAttribute("employee", ShowEmployee.builder().build());
    return "createEmployee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") ShowEmployee restEmployee) {
    Employee employee = mapper.toDomain(restEmployee);
    service.saveOne(employee);
    return "redirect:/";
  }

  @PostMapping("/editEmployee")
  public String editEmployee(@ModelAttribute("employee") EditEmployee editEmployee) {
    Employee employee = mapper.toDomain(editEmployee);
    service.saveOne(employee);
    return "redirect:/";
  }

  @GetMapping("/sort")
  public String SortPage(@RequestParam(value = "sortAttribute", defaultValue = "lastName") String sortAttribute,
                         @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder,
                         Model model) {
    List<Employee> employees = service.sort(sortOrder, sortAttribute);
    model.addAttribute("employees", employees);
    return "index";
  }

  @GetMapping("/search")
  public String SearchPage(@RequestParam("word") String word, Model model) {
    List<Employee> employees = service.searchByWord(word);
    model.addAttribute("employees", employees);
    return "index";
  }

  @GetMapping("/filter")
  public String SearchByDateRange(@RequestParam("entranceDate") LocalDate entranceDate,
                                  @RequestParam("departingDate") LocalDate departingDate,
                                  Model model) {
    List<Employee> employees = service.findEmployeesWithinDateRange(entranceDate, departingDate);
    model.addAttribute("employees", employees);
    return "index";
  }

  @GetMapping("/export")
  public void exportToCSV(@RequestParam("employeeId") String id, HttpServletResponse response) {
    try {
      Employee employee = service.getOne(id);

      List<String> data = new ArrayList<>();
      data.add("Registration Number : " + employee.getRegistrationNumber());
      data.add("Firstname : " + employee.getFirstName());
      data.add("Lastname : " + employee.getLastName());
      data.add("DOB : " + employee.getBirthDate());
      data.add("Gender : " + employee.getSex());
      data.add("Post : " + employee.getPost());
      data.add("Social Professional Category : " + employee.getSocioProfesionalCategory());
      data.add("CNAPS : " + employee.getCNAPS());
      data.add("Personal Email : " + employee.getPersonalEmail());
      data.add("Professional Email : " + employee.getProfessionalEmail());
      data.add("Phone Number : " + employee.getPhoneNumber());
      data.add("Address : " + employee.getAddress());
      data.add("Entrance Date : " + employee.getEntranceDate());
      data.add("Departing Date : " + employee.getDepartingDate());
      data.add("Number Of Children : " + employee.getChildren());

      String fileName = "File_" + employee.getFirstName() + employee.getLastName() + ".csv";
      response.setContentType("text/csv");
      response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

      PrintWriter writer = response.getWriter();

      for (String row : data) {
        writer.println(row);
      }

      writer.flush();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}