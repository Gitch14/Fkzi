package com.example.fkzi.validator;

import com.example.fkzi.model.ConstraintValidationMessage;
import com.example.fkzi.model.UserRequest;

public interface AccountValidator {
    ConstraintValidationMessage validateAccountRequest(UserRequest request);
}
