package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Student;
import com.makeamiracle.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/students/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.count());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.create(student));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(student, id));
    }

    @PatchMapping("/students/changeStatus/{id}")
    public ResponseEntity<Student> changeStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.changeStatus(id));
    }

    @GetMapping("/students/top")
    public ResponseEntity<List<Student>> findTop5(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findTop5());
    }
}
