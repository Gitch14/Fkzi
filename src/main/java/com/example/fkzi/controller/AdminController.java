package com.example.fkzi.controller;


import com.example.fkzi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping("/admin")
    public String admin(Model model) {
        return "adminPanel";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(User user, Model model) {
      //  if (!userService.createUser(user)) {
        //    if (!userServiceImpl.createUser(user)) {
                model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
                return "registration";
        //    }

      //  }
      //  return "redirect:/activate";
    }
}
