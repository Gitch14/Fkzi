package com.example.fkzi.model.dto;

import lombok.Data;

@Data
public class UserResponse {
        private int userId;
        private boolean isActive;
        private boolean isAdmin;
        private String mail;
        private String pass;
        private String fullName;
        private String groupId;
        private String avatar;
        private String userType;
        private String secondUserType;
        private Boolean isOnScholarships;
        private String educationForm;
        private Integer subjectsId;
        private String googleData;

}
