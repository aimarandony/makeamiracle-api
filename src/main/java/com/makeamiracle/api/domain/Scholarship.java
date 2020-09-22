package com.makeamiracle.api.domain;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sponsor sponsor;
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;
    @ManyToOne(fetch = FetchType.LAZY)
    private Degree degree;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        status = "ACTIVO";
    }
}
