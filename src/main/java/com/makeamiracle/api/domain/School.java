package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private SchoolType schoolType;
    @ManyToMany
    private List<Degree> degrees;
}
