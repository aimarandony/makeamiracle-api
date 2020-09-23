package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.Scholarship;
import com.makeamiracle.api.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ScholarshipService {

    @Autowired
    ScholarshipRepository scholarshipRepository;

    public List<Scholarship> findAll(){
        return scholarshipRepository.findAll();
    }

    public Long count() {
        return scholarshipRepository.countScholarshipsByStatusEquals("ACTIVO");
    }

    public Scholarship create(Scholarship scholarship){
        return scholarshipRepository.save(scholarship);
    }

    public Scholarship update(Scholarship scholarship, Long id){
        if (!scholarshipRepository.existsById(id)) throw new NotFoundException("Scholarship does not exist with id " + id);
        Scholarship updScholarship = scholarshipRepository.getOne(id);
        if (scholarship.getSponsor() != null) updScholarship.setSponsor(scholarship.getSponsor());
        if (scholarship.getSchool() != null) updScholarship.setSchool(scholarship.getSchool());
        if (scholarship.getDegree() != null) updScholarship.setDegree(scholarship.getDegree());
        if (scholarship.getCodeStudent() != null) updScholarship.setCodeStudent(scholarship.getCodeStudent());
        scholarshipRepository.save(updScholarship);
        return updScholarship;
    }

    public Scholarship finalize(Scholarship scholarship, Long id){
        if (!scholarshipRepository.existsById(id)) throw new NotFoundException("Scholarship does not exist with id " + id);
        Scholarship updScholarship = scholarshipRepository.getOne(id);
        if (scholarship.getComment() != null) updScholarship.setComment(scholarship.getComment());
        if (scholarship.getStatus() != null) updScholarship.setStatus(scholarship.getStatus());
        updScholarship.setFinishedDate(LocalDate.now());
        scholarshipRepository.save(updScholarship);
        return updScholarship;
    }

    public List<Scholarship> findTop5(){
        return scholarshipRepository.findTop5ByStatusEqualsOrderByFinishedDateDesc("CULMINADO");
    }

}
