package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findCitiesByCountry_Id(Long countryId);
}
