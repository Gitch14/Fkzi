package com.example.fkzi.validator;

import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.model.User;

public interface AccountValidator {
    ConstraintValidationMessage validateAccountRequest(User request);
}
