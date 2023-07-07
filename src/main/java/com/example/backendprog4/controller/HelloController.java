package com.example.backendprog4.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HelloController {
  @RequestMapping(value = "/index")
  public String index() {
    return "index";
  }

  @PostMapping("/save")
  public String saveName(HttpServletRequest request, HttpSession session, Model model) {
    String name = request.getParameter("name");
    session.setAttribute("name", name);
    model.addAttribute("name", name);

    return "redirect:/show";
  }

  @GetMapping("/show")
  public String showName(HttpSession session, Model model) {
    String name = (String) session.getAttribute("name");
    model.addAttribute("name", name);
    return "show";
  }
}