package com.example.fkzi.validator.impl;

import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.model.User;
import com.example.fkzi.model.util.enums.Group;
import com.example.fkzi.validator.AccountValidator;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RegistrationValidation implements AccountValidator {
    public ConstraintValidationMessage validateAccountRequest(User request) {
        ConstraintValidationMessage validationMessage = new ConstraintValidationMessage();
        validationMessage.setListOfErrors(new ArrayList<>());
        validationMessage.setCode(HttpStatus.OK.value());

        if (request == null) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Request body is not valid");
            return validationMessage;
        }

        if (request.getFullName().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("FullName is not valid");
        }

        if (request.getMailboxAddress().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("eMail is not valid");
        }

        if (request.getPassword().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Password is not valid");
        }


        if (request.getGroupId().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("GroupId is not valid");
        }

        if (!EnumUtils.isValidEnum(Group.class, request.getGroupId().toUpperCase())){
                validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
                validationMessage.setMessage("Invalid groupID");
        }



        return validationMessage;
    }
}
