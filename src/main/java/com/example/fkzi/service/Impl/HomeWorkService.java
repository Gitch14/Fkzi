package com.example.fkzi.service.Impl;

import com.example.fkzi.model.Homework;
import com.example.fkzi.model.util.constanta.ConstraintValidationMessage;
import com.example.fkzi.repository.HomeworkRepository;
import com.example.fkzi.validator.impl.HomeTaskValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HomeWorkService {

    private final HomeworkRepository hometaskRepository;
    private final HomeTaskValidationImpl homeTaskValidation;

    @Autowired
    public HomeWorkService(HomeworkRepository hometaskRepository, HomeTaskValidationImpl homeTaskValidation) {
        this.hometaskRepository = hometaskRepository;
        this.homeTaskValidation = homeTaskValidation;
    }

    public Homework saveHomeWork(Homework homeWork) {
        ConstraintValidationMessage validationMessage = homeTaskValidation.validateHomeTaskRequest(homeWork);
        if (validationMessage.getCode() != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(validationMessage.getMessage());
        }
        return hometaskRepository.save(homeWork);
    }
}
