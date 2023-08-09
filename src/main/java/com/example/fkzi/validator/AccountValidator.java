package com.example.fkzi.validator;

import com.example.fkzi.model.ConstraintValidationMessage;
import com.example.fkzi.model.user.User;

public interface AccountValidator {
    ConstraintValidationMessage validateAccountRequest(User request);
}
