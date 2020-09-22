package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {

    Long countScholarshipsByStatusEquals(String status);
    List<Scholarship> findTop5ByStatusEqualsOrderByFinishedDateDesc(String status);
}
