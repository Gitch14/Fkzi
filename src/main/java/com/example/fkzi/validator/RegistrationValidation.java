package com.example.fkzi.validator;

import com.example.fkzi.model.ConstraintValidationMessage;
import com.example.fkzi.model.user.UserRequest;
import com.example.fkzi.model.enumP.Group;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RegistrationValidation implements AccountValidator{
    public ConstraintValidationMessage validateAccountRequest(UserRequest request) {
        ConstraintValidationMessage validationMessage = new ConstraintValidationMessage();
        validationMessage.setListOfErrors(new ArrayList<>());
        validationMessage.setCode(HttpStatus.BAD_REQUEST.value());

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

        if (request.getUserPassword().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("Password is not valid");
        }

        if (request.getJobTitle().isBlank()) {
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

        if (request.getJobTitle().isBlank()) {
            validationMessage.setCode(HttpStatus.BAD_REQUEST.value());
            validationMessage.setMessage("GroupId is not valid");
        }


        return validationMessage;
    }
}
