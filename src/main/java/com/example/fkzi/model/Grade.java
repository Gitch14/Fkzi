package com.example.fkzi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grades")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int gradeValue; // Значение оценки (например, 1, 2, 3, 4, 5)

}

