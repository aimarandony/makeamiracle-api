package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.SchoolType;
import com.makeamiracle.api.repository.SchoolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTypeService {

    @Autowired
    SchoolTypeRepository schoolTypeRepository;

    public List<SchoolType> findAll(){
        return schoolTypeRepository.findAll();
    }

    public Long count(){
        return schoolTypeRepository.count();
    }

    public SchoolType findById(Long id){
        if (!schoolTypeRepository.existsById(id)) throw new NotFoundException("SchoolType does not exist with id " + id);
        return schoolTypeRepository.getOne(id);
    }

    public SchoolType create(SchoolType schoolType){
        return schoolTypeRepository.save(schoolType);
    }
}
