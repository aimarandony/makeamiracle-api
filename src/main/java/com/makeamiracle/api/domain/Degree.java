package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
