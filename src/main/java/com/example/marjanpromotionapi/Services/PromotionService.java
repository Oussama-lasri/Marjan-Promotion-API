package com.example.marjanpromotionapi.Services;

import com.example.marjanpromotionapi.DTO.PromotionDTO;
import com.example.marjanpromotionapi.Models.Promotion;

import java.util.List;

public interface PromotionService {
    public Promotion createPromotion(Promotion promotion , Long categorieId);

    public List<PromotionDTO> promotionList();
}
