package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.District;
import com.makeamiracle.api.service.DistrictService;
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
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @GetMapping("/districts")
    public ResponseEntity<List<District>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(districtService.findAll());
    }

    @GetMapping("/districts/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.status(HttpStatus.OK).body(districtService.count());
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<District> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(districtService.findById(id));
    }

    @GetMapping("/districts/byCity/{cityId}")
    public ResponseEntity<List<District>> findByCountryId(@PathVariable Long cityId) {
        return ResponseEntity.status(HttpStatus.OK).body(districtService.findByCityId(cityId));
    }
}
