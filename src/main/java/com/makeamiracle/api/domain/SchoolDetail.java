package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SchoolDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Degree degree;
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;
}
