package com.example.fkzi.controller;


import com.example.fkzi.model.Subject;
import com.example.fkzi.model.user.User;
import com.example.fkzi.service.Impl.SubjectService;
import com.example.fkzi.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.example.fkzi.model.Constants.*;


@Controller
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('Admin')")
public class AdminController {

    private final SubjectService subjectService;
    private final UserService userService;

    @GetMapping(ADMIN_PANEL)
    public String admin(Model model) {
        return "adminPanel";
    }

    @GetMapping(SUBJECTS)
    public String subjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @PostMapping(ADD_SUBJECT)
    public String addSubject(@RequestParam String subjectName) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/registration1")
    public String regGet(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping(CREATE_USER)
    public ResponseEntity<User> registerUser(@RequestBody User request) {
        User user = new User();
        user.setActive(false);
        user.setAdmin(false);
        user.setMailboxAddress(request.getMailboxAddress());
        user.setUserPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setGroupId(request.getGroupId());
        // user.setAvatar(request.getAvatar()); - coming soon
        user.setJobTitle(request.getJobTitle());
        user.setAdditionalJobTitle(request.getAdditionalJobTitle());
        user.setIsOnScholarships(request.getIsOnScholarships());
        user.setEducationForm(request.getEducationForm());
        user.setSubjectsId(request.getSubjectsId());
        // user.setGoogleData(request.getGoogleData()); - coming soon

        User registeredUser = userService.registration(user);
        return ResponseEntity.ok(registeredUser);
    }
}

