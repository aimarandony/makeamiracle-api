package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.SchoolType;
import com.makeamiracle.api.service.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class SchoolTypeController {

    @Autowired
    SchoolTypeService schoolTypeService;

    @GetMapping("/schoolTypes")
    public ResponseEntity<List<SchoolType>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolTypeService.findAll());
    }

    @GetMapping("/schoolTypes/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolTypeService.count());
    }

    @GetMapping("/schoolTypes/{id}")
    public ResponseEntity<SchoolType> findOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(schoolTypeService.findById(id));
    }
}
