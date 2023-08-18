package com.example.fkzi.controller;

import com.example.fkzi.model.Homework;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.fkzi.model.util.constanta.ConstantsGet.CREATE_HOME_TASK;

@Controller
@PreAuthorize("hasAuthority('ROLE_TEACHER')")
public class TeacherController {


    @GetMapping(CREATE_HOME_TASK)
    public String getHomeTask(Model model){
        Homework homework = new Homework();
        model.addAttribute("homework",homework);
        return "create_homework";
    }


}
