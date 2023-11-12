package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nom ;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Produit> produitList ;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Promotion> promotionList = new ArrayList<>();
}
