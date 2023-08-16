package com.example.fkzi.controller;

import com.example.fkzi.model.Homework;
import com.example.fkzi.service.Impl.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api/hometasks")
public class HomeWorkController {

    private final HomeWorkService hometaskService;

    @Autowired
    public HomeWorkController(HomeWorkService homeWorkService) {
        this.hometaskService = homeWorkService;
    }

    @GetMapping("/home-work")
    public String getHomeTask(){
        return "create_homework";
    }

    @PostMapping
    public ResponseEntity<Homework> createHometask(@RequestBody Homework homework) {
        Homework savedHomeWork = hometaskService.saveHomeWork(homework);
        return new ResponseEntity<>(savedHomeWork, HttpStatus.CREATED);
    }
}
