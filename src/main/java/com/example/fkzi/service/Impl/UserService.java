package com.example.fkzi.service.Impl;

import com.example.fkzi.model.User;
import com.example.fkzi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(User user)
    {

        user.setActive(false);
        user.setAdmin(user.isAdmin());
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

    private UUID generatePass(){
        return UUID.randomUUID();
    }

}
