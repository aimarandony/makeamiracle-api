package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.SchoolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolType, Long> {
}
