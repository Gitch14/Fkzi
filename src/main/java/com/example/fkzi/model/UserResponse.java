package com.example.fkzi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class UserResponse {
    private int userId;
    private boolean isActive;
    private boolean isAdmin;
    private String mailboxAddress;
    private String password;
    private String fullName;
    private String groupId;
    private String avatar;
    private String jobTitle;
    private String additionalJobTitle;
    private Boolean isOnScholarships;
    private String educationForm;
    private Integer subjectsId;
    private String googleData;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return userId == that.userId &&
                isActive == that.isActive &&
                isAdmin == that.isAdmin &&
                Objects.equals(mailboxAddress, that.mailboxAddress) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(additionalJobTitle, that.additionalJobTitle) &&
                Objects.equals(isOnScholarships, that.isOnScholarships) &&
                Objects.equals(educationForm, that.educationForm) &&
                Objects.equals(subjectsId, that.subjectsId) &&
                Objects.equals(googleData, that.googleData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, isActive, isAdmin, mailboxAddress, password, fullName, groupId, avatar, jobTitle, additionalJobTitle, isOnScholarships, educationForm, subjectsId, googleData);
    }
}

