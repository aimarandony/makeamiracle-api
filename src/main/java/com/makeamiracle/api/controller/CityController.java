package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.City;
import com.makeamiracle.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
    }

    @GetMapping("/cities/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.count());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findById(id));
    }

    @GetMapping("/cities/byCountry/{countryId}")
    public ResponseEntity<List<City>> findByCountryId(@PathVariable Long countryId) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.findByCountryId(countryId));
    }

    @PostMapping("/cities")
    public ResponseEntity<City> create(@RequestBody City city) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.create(city));
    }

    @PatchMapping("/cities/{cityId}")
    public ResponseEntity<City> update(@RequestBody City city, @PathVariable Long cityId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.update(city, cityId));
    }
}
