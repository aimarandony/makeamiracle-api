package com.makeamiracle.api.service;

import com.makeamiracle.api.domain.Scholarship;
import com.makeamiracle.api.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Scholarship> findTop5(){
        return scholarshipRepository.findTop5ByStatusEqualsOrderByFinishedDateDesc("CULMINADO");
    }
}
