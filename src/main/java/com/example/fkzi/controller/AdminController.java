package com.example.fkzi.controller;


import com.example.fkzi.model.Subject;
import com.example.fkzi.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final SubjectService subjectService;

    @GetMapping("/admin")
    public String admin(Model model) {
        return "adminPanel";
    }

    @GetMapping("/subjects")
    public String subjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @PostMapping("/addSubject")
    public String addSubject(@RequestParam String subjectName) {

        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }



}
