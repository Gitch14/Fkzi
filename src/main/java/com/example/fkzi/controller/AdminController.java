package com.example.fkzi.controller;


import com.example.fkzi.model.Subject;
import com.example.fkzi.model.User;
import com.example.fkzi.service.Impl.SubjectService;
import com.example.fkzi.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('Admin')")
public class AdminController {

    private final SubjectService subjectService;
    private final UserService userService;

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

    @PostMapping("/registration")
    public ResponseEntity<User> registerUser(@RequestBody User user,
                                             @RequestParam("isActive") Boolean isActive,
                                             @RequestParam("isAdmin") Boolean isAdmin,
                                             @RequestParam("mailboxAddress") String mailboxAddress,
                                             @RequestParam("userPassword") String userPassword,
                                             @RequestParam("fullName") String fullName,
                                             @RequestParam("groupId") String groupId/*,
                                             @RequestParam("avatar") String avatar*/,
                                             @RequestParam("jobTitle") String jobTitle,
                                             @RequestParam("additionalJobTitle") String additionalJobTitle,
                                             @RequestParam("isOnScholarships") Boolean isOnScholarships,
                                             @RequestParam("educationForm") String educationForm,
                                             @RequestParam("subjectsId") Integer subjectsId/*,
                                             @RequestParam("googleData") String googleData*/) {

        user.setActive(isActive);
        user.setAdmin(isAdmin);
        user.setMailboxAddress(mailboxAddress);
        user.setUserPassword(userPassword);
        user.setFullName(fullName);
        user.setGroupId(groupId);
        // user.setAvatar(avatar); - coming soon
        user.setJobTitle(jobTitle);
        user.setAdditionalJobTitle(additionalJobTitle);
        user.setIsOnScholarships(isOnScholarships);
        user.setEducationForm(educationForm);
        user.setSubjectsId(subjectsId);
        // user.setGoogleData(googleData); - coming soon

        User registeredUser = userService.registration(user);
        return ResponseEntity.ok(registeredUser);
    }
}

