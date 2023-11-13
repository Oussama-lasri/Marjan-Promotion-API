package com.example.marjanpromotionapi.Services.Impl;

import com.example.marjanpromotionapi.Enums.StatusPromo;
import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Models.ResponsableRayon;
import com.example.marjanpromotionapi.Repositories.PromotionRepository;
import com.example.marjanpromotionapi.Repositories.ResponsableRayonRepository;
import com.example.marjanpromotionapi.Services.ResponsableRayonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccepterOuRefuserPromotionImp implements ResponsableRayonService {

    private final PromotionRepository promotionRepository;
    private final ResponsableRayonRepository responsableRayonRepository ;

    public AccepterOuRefuserPromotionImp (PromotionRepository promotionRepository ,ResponsableRayonRepository responsableRayonRepository ){
        this.promotionRepository = promotionRepository ;
        this.responsableRayonRepository = responsableRayonRepository ;
    }

    @Override
    public Promotion accepterOuRefuserPromotion(Long promotionId, Long responsableId, StatusPromo statusPromo) {
        if (responsableId != null) {
            Optional<ResponsableRayon> responsableRayon = responsableRayonRepository.findById(responsableId);

            if (responsableRayon.isPresent()) {
                Optional<Promotion> promotion = promotionRepository.findById(promotionId);
                if (promotion.isPresent()) {
                    promotion.get().setStatus(statusPromo);
                    return promotionRepository.save(promotion.get());
                }
            }
        }

        throw new EntityNotFoundException("Either ResponsableRayon or Promotion not found");
    }

    @Override
    public ResponsableRayon create(ResponsableRayon responsableRayon) {
        return responsableRayonRepository.save(responsableRayon);
    }
}
