package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.Degree;
import com.makeamiracle.api.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeService {

    @Autowired
    DegreeRepository degreeRepository;

    public List<Degree> findAll(){
        return degreeRepository.findAll();
    }

    public Long count(){
        return degreeRepository.count();
    }

    public Degree findById(Long id){
        if (!degreeRepository.existsById(id)) throw new NotFoundException("Degree does not exist with id " +  id);
        return degreeRepository.getOne(id);
    }

    public Degree create(Degree degree){
        return degreeRepository.save(degree);
    }

    public Degree update(Degree degree, Long id){
        if (!degreeRepository.existsById(id)) throw new NotFoundException("Degree does not exist with id " +  id);
        Degree updDegree = degreeRepository.getOne(id);
        if (updDegree.getName() != null) updDegree.setName(degree.getName());
        degreeRepository.save(updDegree);
        return updDegree;
    }

    public List<Degree> createAll(List<Degree> degrees){
        return degreeRepository.saveAll(degrees);
    }
}
