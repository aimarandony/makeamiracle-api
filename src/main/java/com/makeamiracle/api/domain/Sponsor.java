package com.makeamiracle.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passport;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @PrePersist
    public void prePersist(){
        status = true;
    }
}
