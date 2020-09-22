package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdAt;
    private Boolean status;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        status = true;
    }
}
