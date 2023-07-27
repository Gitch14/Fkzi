package com.example.fkzi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homeworks")
@Data
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_id")
    private int homeworkId;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "homeworks_description", nullable = false, columnDefinition = "varchar(255) collate utf8mb4_unicode_ci")
    private String homeworksDescription;

    @Column(name = "links", columnDefinition = "varchar(255) collate utf8mb4_unicode_ci")
    private String links;

    @Column(name = "additional_materials", columnDefinition = "varchar(255) collate utf8mb4_unicode_ci")
    private String additionalMaterials;
}
