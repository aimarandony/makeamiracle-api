package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    Long countBySchoolType_Name(String nameSchoolType);
}
