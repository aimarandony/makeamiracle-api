package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.Sponsor;
import com.makeamiracle.api.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","https://makeamiracle.netlify.app"})
@RestController
@RequestMapping("/api")
public class SponsorController {

    @Autowired
    SponsorService sponsorService;

    @GetMapping("/sponsors")
    public ResponseEntity<List<Sponsor>> find(){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.findAll());
    }

    @GetMapping("/sponsors/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.count());
    }

    @GetMapping("/sponsors/{id}")
    public ResponseEntity<Sponsor> findOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.findById(id));
    }

    @PostMapping("/sponsors")
    public ResponseEntity<Sponsor> create(@RequestBody Sponsor sponsor){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.create(sponsor));
    }

    @PatchMapping("/sponsors/{id}")
    public ResponseEntity<Sponsor> update(@RequestBody Sponsor sponsor, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.update(sponsor, id));
    }

    @PatchMapping("/sponsors/changeStatus/{id}")
    public ResponseEntity<Sponsor> changeStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sponsorService.changeStatus(id));
    }
}
