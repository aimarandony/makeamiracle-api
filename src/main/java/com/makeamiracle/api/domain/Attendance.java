package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private LocalTime realizedTime;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;

    @PrePersist
    public void prePersist(){
        status = true;
        arrivalTime = LocalTime.now();
    }
}
