package com.example.fkzi.service.Impl;

import com.example.fkzi.model.Homework;
import com.example.fkzi.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeWorkService {

    private final HomeworkRepository hometaskRepository;

    @Autowired
    public HomeWorkService(HomeworkRepository hometaskRepository) {
        this.hometaskRepository = hometaskRepository;
    }

    public Homework saveHomeWork(Homework homeWork) {
        return hometaskRepository.save(homeWork);
    }
}
