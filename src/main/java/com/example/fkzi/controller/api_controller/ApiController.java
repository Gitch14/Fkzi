package com.example.fkzi.controller.api_controller;

import com.example.fkzi.model.Subject;
import com.example.fkzi.model.User;
import com.example.fkzi.service.Impl.SubjectService;
import com.example.fkzi.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fkzi.model.util.constanta.ConstantsPost.ADD_SUBJECT;
import static com.example.fkzi.model.util.constanta.ConstantsPost.CREATE_USER;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;
    private final SubjectService subjectService;
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

    @PostMapping(ADD_SUBJECT)
    public  ResponseEntity<Subject> addSubject1(@RequestBody Subject subject) {
        Subject newSubject = new Subject();
        newSubject.setSubjectName(subject.getSubjectName());
        newSubject.setLearningMaterials(subject.getLearningMaterials());
        Subject createSubject = subjectService.saveSubject(subject);
        return ResponseEntity.ok(createSubject);
    }
}
