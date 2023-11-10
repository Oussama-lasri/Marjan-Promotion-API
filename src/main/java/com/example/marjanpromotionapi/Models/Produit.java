package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Data
@Component
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title ;
    private Float prix ;
    @ManyToOne
    private Categorie categorie ;
    @CreationTimestamp
    private LocalDateTime createdOn ;
    @UpdateTimestamp
    private LocalDateTime updatedOn ;

}
