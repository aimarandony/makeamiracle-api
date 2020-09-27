package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.SchoolDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDetailRepository extends JpaRepository<SchoolDetail, Long> {
}
