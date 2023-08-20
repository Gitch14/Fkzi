package com.example.fkzi.controller;

import com.example.fkzi.model.User;
import com.example.fkzi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final PasswordEncoder passwordEncoder;

    public MainController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "redirect:/";
    }

    @GetMapping("/F-admin")
    public String fAdmin() {

        return "first-admin";
    }

    @PostMapping("/first-admin")
    public String firstAdmin(){
        User user = new User();
        user.setAdmin(true);
        user.setActive(true);
        user.setMailboxAddress("root@gmail.com");
        user.setUserPassword(passwordEncoder.encode("root"));
        user.setFullName("root");
        user.setGroupId("KN_41");
        user.setJobTitle("ROLE_ADMIN");
        user.setAdditionalJobTitle("ROLE_ADMIN");
        user.setIsOnScholarships(true);
        user.setEducationForm("Full_time");
        user.setSubjectsId(1337);


        if (userRepository.findByFullName("root") != null) {
            logger.warn("Pidoraz detectited");
            return "redirect:/";
        }
        userRepository.save(user);

        return "redirect:/";
    }
}
