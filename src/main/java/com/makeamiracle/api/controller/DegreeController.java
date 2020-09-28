package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Degree;
import com.makeamiracle.api.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class DegreeController {

    @Autowired
    DegreeService degreeService;

    @GetMapping("/degrees")
    public ResponseEntity<List<Degree>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.findAll());
    }

    @GetMapping("/degrees/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.count());
    }

    @GetMapping("/degrees/{id}")
    public ResponseEntity<Degree> findOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.findById(id));
    }

    @PostMapping("/degrees")
    public ResponseEntity<Degree> create(@RequestBody Degree degree){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.create(degree));
    }

    @PatchMapping("/degrees/{id}")
    public ResponseEntity<Degree> update(@RequestBody Degree degree, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.update(degree, id));
    }

    @PostMapping("/degrees/createAll")
    public ResponseEntity<List<Degree>> createAll(@RequestBody List<Degree> degrees){
        return ResponseEntity.status(HttpStatus.OK).body(degreeService.createAll(degrees));
    }
}
