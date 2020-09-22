package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.District;
import com.makeamiracle.api.repository.CityRepository;
import com.makeamiracle.api.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    CityRepository cityRepository;

    public List<District> findAll(){
        return districtRepository.findAll();
    }

    public Long count(){
        return districtRepository.count();
    }

    public District findById(Long id){
        if (!districtRepository.existsById(id)) throw new NotFoundException("District does not exist with id " + id);
        return districtRepository.getOne(id);
    }

    public List<District> findByCityId(Long cityId){
        if (!cityRepository.existsById(cityId)) throw new NotFoundException("City does not exist with id " + cityId);
        return districtRepository.findDistrictsByCity_Id(cityId);
    }
}
