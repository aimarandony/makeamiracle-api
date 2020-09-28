package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Country;
import com.makeamiracle.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(countryService.findAll());
    }

    @GetMapping("/countries/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.count());
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.findById(id));
    }

}
