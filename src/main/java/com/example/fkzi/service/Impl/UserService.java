package com.example.fkzi.service.Impl;

import com.example.fkzi.model.ConstraintValidationMessage;
import com.example.fkzi.model.User;
import com.example.fkzi.model.UserRequest;
import com.example.fkzi.repository.UserRepository;
import com.example.fkzi.validator.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RegistrationValidation registrationValidation;

    @Autowired
    public UserService(UserRepository userRepository, RegistrationValidation registrationValidation) {
        this.userRepository = userRepository;
        this.registrationValidation = registrationValidation;
    }

    public User registration(User user)
    {

        ConstraintValidationMessage validationMessage = registrationValidation.validateAccountRequest(convertToUserRequest(user));
        if (validationMessage.getCode() != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(validationMessage.getMessage());
        }
        user.setActive(false);
        user.setAdmin(false);
        user.setMailboxAddress(user.getMailboxAddress());
        user.setUserPassword(String.valueOf(generatePass()));
        user.setFullName(user.getFullName());
        user.setGroupId(user.getGroupId());
        //  user.setAvatar(avatar); - coming soon
        user.setJobTitle(user.getJobTitle());
        user.setAdditionalJobTitle(user.getAdditionalJobTitle());
        user.setIsOnScholarships(user.getIsOnScholarships());
        user.setEducationForm(user.getEducationForm());
        user.setSubjectsId(user.getSubjectsId());
      //  user.setGoogleData(googleData); - coming soon


        return userRepository.save(user);
    }

    private UserRequest convertToUserRequest(User user) {
        UserRequest request = new UserRequest();
        request.setIsActive(user.isActive());
        request.setIsAdmin(user.isAdmin());
        request.setMailboxAddress(user.getMailboxAddress());
        request.setUserPassword(user.getUserPassword());
        request.setFullName(user.getFullName());
        request.setGroupId(user.getGroupId());
        request.setJobTitle(user.getJobTitle());
        request.setAdditionalJobTitle(user.getAdditionalJobTitle());
        request.setIsOnScholarships(user.getIsOnScholarships());
        request.setEducationForm(user.getEducationForm());
        request.setSubjectsId(user.getSubjectsId());

        return request;
    }

    private UUID generatePass(){
        return UUID.randomUUID();
    }

}
