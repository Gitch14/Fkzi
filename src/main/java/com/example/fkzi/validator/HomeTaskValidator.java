package com.example.fkzi.validator;

import com.example.fkzi.model.Homework;
import com.example.fkzi.model.Subject;
import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;

public interface HomeTaskValidator {
    ConstraintValidationMessage validateHomeTaskRequest(Homework request);
}
