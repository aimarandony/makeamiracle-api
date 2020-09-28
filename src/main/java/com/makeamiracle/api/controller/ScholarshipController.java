package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Scholarship;
import com.makeamiracle.api.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
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

    @PostMapping("/scholarships")
    public ResponseEntity<Scholarship> create(@RequestBody Scholarship scholarship){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.create(scholarship));
    }

    @PatchMapping("/scholarships/{id}")
    public ResponseEntity<Scholarship> update(@RequestBody Scholarship scholarship, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.update(scholarship, id));
    }

    @PatchMapping("/scholarships/finalize/{id}")
    public ResponseEntity<Scholarship> finalize(@RequestBody Scholarship scholarship, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.finalize(scholarship, id));
    }
}
