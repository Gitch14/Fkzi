package com.example.fkzi.service.Impl;

import com.example.fkzi.model.Subject;
import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.repository.SubjectRepository;
import com.example.fkzi.validator.impl.SubjectValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectValidationImpl subjectValidation;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, SubjectValidationImpl subjectValidation) {
        this.subjectRepository = subjectRepository;
        this.subjectValidation = subjectValidation;
    }

    public Subject saveSubject(Subject subject) {

        ConstraintValidationMessage validationMessage = subjectValidation.validateSubjectRequest(subject);
        if (validationMessage.getCode() != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(validationMessage.getMessage());
        }
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}

