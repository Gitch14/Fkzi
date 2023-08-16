package com.example.fkzi.validator.impl;

import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.model.Subject;
import com.example.fkzi.validator.SubjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SubjectValidationImpl implements SubjectValidator {
    public ConstraintValidationMessage validateSubjectRequest(Subject entity) {
        ConstraintValidationMessage validationMessage = new ConstraintValidationMessage();
        validationMessage.setListOfErrors(new ArrayList<>());
        validationMessage.setCode(HttpStatus.OK.value());

        if (entity == null) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Request body is not valid");
            return validationMessage;
        }

        if (entity.getSubjectName().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Subject Name is not valid");
        }

        return validationMessage;
    }
}

