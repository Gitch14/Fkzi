package com.example.fkzi.controller.api_controller;

import com.example.fkzi.model.Homework;
import com.example.fkzi.model.Subject;
import com.example.fkzi.model.User;
import com.example.fkzi.service.Impl.HomeWorkService;
import com.example.fkzi.service.Impl.SubjectService;
import com.example.fkzi.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fkzi.model.util.constanta.ConstantsPost.*;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;
    private final SubjectService subjectService;
    private final HomeWorkService hometaskService;
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
    public  ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject newSubject = new Subject();
        newSubject.setSubjectName(subject.getSubjectName());
        newSubject.setLearningMaterials(subject.getLearningMaterials());
        Subject createSubject = subjectService.saveSubject(subject);
        return ResponseEntity.ok(createSubject);
    }

    @PostMapping(CREATE_HOMEWROK)
    public ResponseEntity<Homework> createHometask(@RequestBody Homework homework) {
        Homework newHomework = new Homework();
        newHomework.setDueDate(homework.getDueDate());
        newHomework.setHomeworksDescription(homework.getHomeworksDescription());
        newHomework.setLinks(homework.getLinks());
        newHomework.setAdditionalMaterials(homework.getAdditionalMaterials());
        Homework savedHomeWork = hometaskService.saveHomeWork(newHomework);
        return ResponseEntity.ok(savedHomeWork);
    }

    @PostMapping("/user/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User request) {
        User updatedUser = userService.updateUser(userId, request);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
