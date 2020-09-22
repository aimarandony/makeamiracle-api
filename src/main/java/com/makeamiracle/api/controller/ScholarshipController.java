package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Scholarship;
import com.makeamiracle.api.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScholarshipController {

    @Autowired
    ScholarshipService scholarshipService;

    @GetMapping("/scholarships")
    public ResponseEntity<List<Scholarship>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.findAll());
    }

    @GetMapping("/scholarships/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.count());
    }

    @GetMapping("/scholarships/top")
    public ResponseEntity<List<Scholarship>> findTop5(){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.findTop5());
    }
}
