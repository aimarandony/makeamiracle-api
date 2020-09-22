package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private Boolean status;

    @PrePersist
    public void prePersist(){
        status = true;
    }
}
