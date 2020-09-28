package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.School;
import com.makeamiracle.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @GetMapping("/schools")
    public ResponseEntity<List<School>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.findAll());
    }

    @GetMapping("/schools/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.count());
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<School> findOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.findById(id));
    }

    @PostMapping("/schools")
    public ResponseEntity<School> create(@RequestBody School school){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.create(school));
    }

    @PatchMapping("/schools/{id}")
    public ResponseEntity<School> update(@RequestBody School school, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.update(school, id));
    }

    @GetMapping("/schools/countByType")
    public ResponseEntity<Map> countByType(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("instituto", schoolService.countBySchoolType("INSTITUTO"));
        resp.put("universidad", schoolService.countBySchoolType("UNIVERSIDAD"));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
