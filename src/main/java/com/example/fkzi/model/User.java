package com.example.fkzi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String groupNumber;
    private String educationForm;
    private UserType userType;


    public enum UserType {
        STUDENT,
        TEACHER,
        ADMIN
    }
}

