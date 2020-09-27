package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.SchoolDetail;
import com.makeamiracle.api.service.SchoolDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolDetailController {

    @Autowired
    SchoolDetailService schoolDetailService;

    @GetMapping("/schoolDetails")
    public ResponseEntity<List<SchoolDetail>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolDetailService.findAll());
    }

    @PostMapping("/schoolDetails")
    public ResponseEntity<SchoolDetail> create(@RequestBody SchoolDetail schoolDetail){
        return ResponseEntity.status(HttpStatus.OK).body(schoolDetailService.create(schoolDetail));
    }
}
