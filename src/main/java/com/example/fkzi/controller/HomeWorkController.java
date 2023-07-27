package com.example.fkzi.controller;

import com.example.fkzi.model.Homework;
import com.example.fkzi.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hometasks")
public class HomeWorkController {

    private final HomeWorkService hometaskService;

    @Autowired
    public HomeWorkController(HomeWorkService homeWorkService) {
        this.hometaskService = homeWorkService;
    }

    @PostMapping
    public ResponseEntity<Homework> createHometask(@RequestBody Homework homework) {
        Homework savedHomeWork = hometaskService.saveHomeWork(homework);
        return new ResponseEntity<>(savedHomeWork, HttpStatus.CREATED);
    }
}
