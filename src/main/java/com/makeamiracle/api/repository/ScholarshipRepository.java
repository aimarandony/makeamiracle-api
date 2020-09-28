package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
    List<Scholarship> findTop5ByStatusOrderByFinishedDateDesc(String status);
}
