package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String name;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private Boolean status;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @PrePersist
    public void prePersist(){
        status = true;
        createdAt = LocalDateTime.now();
    }
}
