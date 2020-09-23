package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.SchoolType;
import com.makeamiracle.api.service.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
