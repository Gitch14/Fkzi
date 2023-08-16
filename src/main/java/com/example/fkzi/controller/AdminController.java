package com.example.fkzi.controller;


import com.example.fkzi.model.Subject;
import com.example.fkzi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.fkzi.model.util.constanta.ConstantsGet.*;



@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    @GetMapping(ADMIN_PANEL)
    public String admin(Model model) {
        return "adminPanel";
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


}

