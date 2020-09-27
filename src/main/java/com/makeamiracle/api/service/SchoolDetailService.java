package com.makeamiracle.api.service;

import com.makeamiracle.api.domain.SchoolDetail;
import com.makeamiracle.api.repository.SchoolDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDetailService {

    @Autowired
    SchoolDetailRepository schoolDetailRepository;

    public List<SchoolDetail> findAll(){
        return schoolDetailRepository.findAll();
    }

    public SchoolDetail create(SchoolDetail schoolDetail){
        return schoolDetailRepository.save(schoolDetail);
    }
}
