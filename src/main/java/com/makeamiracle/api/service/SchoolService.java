package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.School;
import com.makeamiracle.api.repository.SchoolRepository;
import com.makeamiracle.api.repository.SchoolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    SchoolTypeRepository schoolTypeRepository;

    public List<School> findAll(){
        return schoolRepository.findAll();
    }

    public Long count(){
        return schoolRepository.count();
    }

    public School findById(Long id){
        if (!schoolRepository.existsById(id)) throw new NotFoundException("School does not exist with id " + id);
        return schoolRepository.getOne(id);
    }

    public School create(School school){
        Long schoolTypeId = school.getSchoolType().getId();
        if (!schoolTypeRepository.existsById(schoolTypeId)) throw new NotFoundException("SchoolType does not exist with id " + schoolTypeId);
        return schoolRepository.save(school);
    }

    public School update(School school, Long id){
        Long schoolTypeId = school.getSchoolType().getId();
        if (!schoolRepository.existsById(id)) throw new NotFoundException("School does not exist with id " + id);
        if (!schoolTypeRepository.existsById(schoolTypeId)) throw new NotFoundException("SchoolType does not exist with id " + schoolTypeId);
        School updSchool = schoolRepository.getOne(id);
        if (school.getName() != null) updSchool.setName(school.getName());
        if (school.getSchoolType() != null) updSchool.setSchoolType(school.getSchoolType());
        schoolRepository.save(updSchool);
        return updSchool;
    }

    public Long countBySchoolType(String nameSchoolType){
        return schoolRepository.countBySchoolType_Name(nameSchoolType);
    }
}
