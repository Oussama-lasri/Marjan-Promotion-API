package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.DTO.CategorieDTO;
import com.example.marjanpromotionapi.DTO.ProduitDTO;
import com.example.marjanpromotionapi.DTO.PromotionDTO;
import com.example.marjanpromotionapi.Models.Categorie;
import com.example.marjanpromotionapi.Models.Produit;
import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Repositories.CategoryRepository;
import com.example.marjanpromotionapi.Repositories.ProduitRepository;
import com.example.marjanpromotionapi.Repositories.PromotionRepository;
import com.example.marjanpromotionapi.Services.PromotionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PromotionServiceImp implements PromotionService {
    private final PromotionRepository promotionRepository ;
    private final CategoryRepository categoryRepository ;
    private final ProduitRepository produitRepository ;
    @Autowired
    public PromotionServiceImp(PromotionRepository promotionRepository , ProduitRepository produitRepository , CategoryRepository categoryRepository) {
        this.promotionRepository = promotionRepository;
        this.categoryRepository = categoryRepository ;
        this.produitRepository = produitRepository ;

    }

    @Override
    public Promotion createPromotion(Promotion promotion, Long categorieId) {
        Optional<Categorie> categorie = categoryRepository.findById(categorieId);
        if (categorie.isPresent()) {
            promotion.setCategorie(categorie.get());
            Promotion promotionCreated = promotionRepository.save(promotion);
            categorie.get().getProduitList().forEach(produit -> {
                produit.setPromotion(promotion);
                produitRepository.save(produit);
            });
            // categorie.get().getProduitList().forEach(produit -> produit.setPromotion(promotion));
            // produitRepository.saveAll(categorie.get().getProduitList());

            return promotionCreated;
        }
        return null ;
    }

    @Override
    public List<PromotionDTO> promotionList() {

        return promotionRepository.findAll().stream().map(promotion -> mapToPromotionDTO(promotion)).collect(Collectors.toList());
    }

    private PromotionDTO mapToPromotionDTO(Promotion promotion) {
        return PromotionDTO.builder()
                .id(promotion.getId())
                .dateFin(promotion.getDateFin())
                .description(promotion.getDescription())
                .precentage(promotion.getPrecentage())
                .produitList(mapToProduitDTOlist(promotion.getProduitList()))
                .status(promotion.getStatus())
                .categorie(mapToCategorieDTO(promotion.getCategorie()))
                .dateDebut(promotion.getDateDebut())
                .build();
    }

    private CategorieDTO mapToCategorieDTO(Categorie categorie) {
        if (categorie != null) {
            return CategorieDTO.builder()
                    .nom(categorie.getNom())
                    .id(categorie.getId())
                    .build();
        } else {
            return null;
        }
    }

    private List<ProduitDTO> mapToProduitDTOlist(List<Produit> produitList) {
        return produitList.stream().map(produit -> mapToProduitDTO(produit)).collect(Collectors.toList());
    }

    private ProduitDTO mapToProduitDTO(Produit produit) {
        return ProduitDTO.builder()
                .title(produit.getTitre())
                .prix(produit.getPrix())
                .id(produit.getId())
                .build();
    }
}
