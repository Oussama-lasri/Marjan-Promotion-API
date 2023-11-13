package com.example.marjanpromotionapi.Services;

import com.example.marjanpromotionapi.Enums.StatusPromo;
import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Models.ResponsableRayon;

public interface ResponsableRayonService {
    public Promotion accepterOuRefuserPromotion(Long promotion_id, Long responsable_id, StatusPromo statusPromo);

    public ResponsableRayon create(ResponsableRayon responsableRayon);
}
