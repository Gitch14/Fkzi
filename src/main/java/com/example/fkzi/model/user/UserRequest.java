package com.example.fkzi.model.user;

import lombok.Data;

@Data
public class UserRequest {
    private Boolean isActive;
    private Boolean isAdmin;
    private String firstName;
    private String lastName;
    private String mailboxAddress;
    private String userPassword;
    private String fullName;
    private String groupId;
    private String avatar;
    private String jobTitle;
    private String additionalJobTitle;
    private Boolean isOnScholarships;
    private String educationForm;
    private Integer subjectsId;
    private String googleData;

}
