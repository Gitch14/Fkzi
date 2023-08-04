package com.example.fkzi.model;

import com.example.fkzi.model.user.User;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "journal_data")
@Data
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journal_id")
    private int journalId;

    @Column(name = "student_id", nullable = false)
    private int studentId;

    @Column(name = "teacher_id", nullable = false)
    private int teacherId;

    @Column(name = "homework_id")
    private Integer homeworkId;

    @Column(name = "record_description", nullable = false)
    private String recordDescription;

    @Column(name = "record_type", nullable = false)
    private String recordType;

    @Column(name = "group_id", nullable = false, length = 10)
    private String groupId;

    @Column(name = "date_pointer", nullable = false)
    private Date datePointer;

    @Column(name = "lecture_number")
    private Byte lectureNumber;

    @Column(name = "week_day", nullable = false)
    private Byte weekDay;

    @Column(name = "presence")
    private Boolean presence;

    @Column(name = "grade")
    private Byte grade;

    @Column(name = "subject_id")
    private Integer subjectId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User teacher;

    @ManyToOne
    @JoinColumn(name = "homework_id", referencedColumnName = "homework_id", insertable = false, updatable = false)
    private Homework homework;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", insertable = false, updatable = false)
    private Subject subject;
}
