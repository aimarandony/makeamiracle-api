package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.City;
import com.makeamiracle.api.repository.CityRepository;
import com.makeamiracle.api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City findById(Long id){
        if (!cityRepository.existsById(id)) throw new NotFoundException("City does not exist with id " + id);
        return cityRepository.getOne(id);
    }

    public Long count(){
        return cityRepository.count();
    }

    public City create(City city){
        return cityRepository.save(city);
    }

    public City update(City city, Long id){
        if (!cityRepository.existsById(id)) throw new NotFoundException("City does not exist with id " + id);
        City updCity = cityRepository.getOne(id);
        if(city.getName() != null) updCity.setName(city.getName());
        if(city.getCountry() != null) updCity.setCountry(city.getCountry());
        cityRepository.save(updCity);
        return updCity;
    }

    public List<City> findByCountryId(Long countryId){
        if (!countryRepository.existsById(countryId)) throw new NotFoundException("Country does not exist with id " + countryId);
        return cityRepository.findCitiesByCountry_Id(countryId);
    }
}
