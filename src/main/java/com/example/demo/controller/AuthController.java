package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class AuthController {

  private final Map<String, String> userStore = new ConcurrentHashMap<>();

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }

  @PostMapping("/register")
  public String register(@RequestParam String username, @RequestParam String password) {
    userStore.put(username, password);
    return "redirect:/login";
  }

  @GetMapping("/home")
  public String home(Model model) {
    return "home";
  }
}
