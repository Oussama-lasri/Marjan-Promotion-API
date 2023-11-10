package com.example.marjanpromotionapi.Models;

import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity


public class Centre {
    @Id
    @GeneratedValue
    private Long id ;
    private String label ;
    private String ville ;
    @Inject
    @ManyToOne
    private AdminCentre adminCentre ;
}
