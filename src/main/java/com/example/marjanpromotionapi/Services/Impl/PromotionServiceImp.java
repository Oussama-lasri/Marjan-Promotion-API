package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.Models.Categorie;
import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Repositories.CategoryRepository;
import com.example.marjanpromotionapi.Repositories.PromotionRepository;
import com.example.marjanpromotionapi.Services.PromotionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PromotionServiceImp implements PromotionService {
    private final PromotionRepository promotionRepository ;
    private final CategoryRepository categoryRepository ;
    @Autowired
    public PromotionServiceImp(PromotionRepository promotionRepository , CategoryRepository categoryRepository) {
        this.promotionRepository = promotionRepository;
        this.categoryRepository = categoryRepository ;

    }

    @Override
    public Promotion createPromotion(Promotion promotion, Long categorieId) {
        Optional<Categorie> categorie = categoryRepository.findById(categorieId);
        Promotion promotionCreated =  promotionRepository.save(promotion);
        categorie.get().getProduitList().stream().forEach(produit -> {
            produit.setPromotion(promotion);
        });





        return promotionCreated;
    }

    @Override
    public List<Promotion> promotionList() {
        return null;
    }
}
