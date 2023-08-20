package com.example.fkzi.service.Impl;

import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.model.User;
import com.example.fkzi.repository.UserRepository;
import com.example.fkzi.validator.impl.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RegistrationValidation registrationValidation;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RegistrationValidation registrationValidation, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.registrationValidation = registrationValidation;
        this.passwordEncoder = passwordEncoder;
    }


    public User registration(User user)
    {

        ConstraintValidationMessage validationMessage = registrationValidation.validateAccountRequest(user);
        if (validationMessage.getCode() != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(validationMessage.getMessage());
        }

        user.setActive(true);
        user.setAdmin(false);
        user.setMailboxAddress(user.getMailboxAddress());
        user.setUserPassword(passwordEncoder.encode(user.getPassword()));
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

    public User findUserById(User user){
        int id = user.getUserId();
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Integer userId, User request) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setMailboxAddress(request.getMailboxAddress());
            user.setFullName(request.getFullName());
            user.setGroupId(request.getGroupId());
            user.setJobTitle(request.getJobTitle());
            user.setAdditionalJobTitle(request.getAdditionalJobTitle());
            user.setIsOnScholarships(request.getIsOnScholarships());
            user.setEducationForm(request.getEducationForm());
            user.setSubjectsId(request.getSubjectsId());

            // google & avatar make later

            return userRepository.save(user);
        } else {
            return null;
        }
    }

    private UUID generatePass(){
        return UUID.randomUUID();
    }

}
