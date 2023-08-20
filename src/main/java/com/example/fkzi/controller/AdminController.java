package com.example.fkzi.controller;


import com.example.fkzi.model.Subject;
import com.example.fkzi.model.User;
import com.example.fkzi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.example.fkzi.model.util.constanta.ConstantsGet.*;



@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserRepository userRepository;

    @GetMapping(ADMIN_PANEL)
    public String admin(Model model) {
        List<User> user = userRepository.findAll();
        model.addAttribute("user",user);
        return "admin";
    }

    @GetMapping(SUBJECTS)
    public String subjects(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "add_Subject";
    }

    @GetMapping(REGISTRATION)
    public String regGet(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable Integer id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "user_details";
    }


}

