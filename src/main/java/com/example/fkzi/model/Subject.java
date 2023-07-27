package com.example.fkzi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "subject_name", nullable = false, columnDefinition = "varchar(255) collate utf8mb4_unicode_ci")
    private String subjectName;

    @Column(name = "learning_materials", columnDefinition = "varchar(255) collate utf8mb4_unicode_ci")
    private String learningMaterials;

}


