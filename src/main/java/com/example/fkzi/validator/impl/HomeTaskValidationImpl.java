package com.example.fkzi.validator.impl;

import com.example.fkzi.model.Homework;
import com.example.fkzi.model.Subject;
import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.validator.HomeTaskValidator;
import com.example.fkzi.validator.SubjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HomeTaskValidationImpl implements HomeTaskValidator {
    public ConstraintValidationMessage validateHomeTaskRequest(Homework entity) {
        ConstraintValidationMessage validationMessage = new ConstraintValidationMessage();
        validationMessage.setListOfErrors(new ArrayList<>());
        validationMessage.setCode(HttpStatus.OK.value());

        if (entity == null) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Request body is not valid");
            return validationMessage;
        }

        if (entity.getDueDate() == null) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Data is not valid");
        }

        if (entity.getHomeworksDescription().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Home description is not valid");
        }

        return validationMessage;
    }
}

