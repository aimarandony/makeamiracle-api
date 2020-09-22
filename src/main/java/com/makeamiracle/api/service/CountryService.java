package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.Country;
import com.makeamiracle.api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    public Long count(){
        return countryRepository.count();
    }

    public Country findById(Long id){
        if (!countryRepository.existsById(id)) throw new NotFoundException("Country does not exist with id " + id);
        return countryRepository.getOne(id);
    }

}
