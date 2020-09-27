package com.makeamiracle.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String codeStudent;
    private LocalDateTime createdAt;
    private LocalDate finishedDate;
    private String status;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Sponsor sponsor;
    @ManyToOne
    @JsonIgnoreProperties({"degrees", "hibernateLazyInitializer", "handler"})
    private School school;
    @ManyToOne
    private Degree degree;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        status = "ACTIVO";
    }
}
