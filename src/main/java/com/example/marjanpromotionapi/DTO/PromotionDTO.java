package com.example.marjanpromotionapi.DTO;

import com.example.marjanpromotionapi.Enums.StatusPromo;
import com.example.marjanpromotionapi.Models.Categorie;
import com.example.marjanpromotionapi.Models.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PromotionDTO {
    private Long id;
    private Double precentage;
    private String description;
    private StatusPromo status;
    private Date dateDebut;
    private Date dateFin;
    private List<ProduitDTO> produitList = new ArrayList<>();
    private CategorieDTO categorie;
}
