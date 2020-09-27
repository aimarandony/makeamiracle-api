package com.makeamiracle.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SchoolDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties({"degrees", "hibernateLazyInitializer", "handler"})
    private School school;
    @ManyToOne
    private Degree degree;
}
