package com.example.marjanpromotionapi.Models;

import com.example.marjanpromotionapi.Enums.StatusPromo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precentage;
    private String description;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(EnumType.STRING)
    private StatusPromo status;
    private Date dateDebut;
    private Date dateFin;
    @OneToMany(mappedBy = "promotion")
    private List<Produit> produitList = new ArrayList<>();
    @ManyToOne
    private Categorie categorie;

    @Transient
    private Long categorieId;

}
