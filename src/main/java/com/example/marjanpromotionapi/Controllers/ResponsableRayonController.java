package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.DTO.PromotionRequest;
import com.example.marjanpromotionapi.Enums.StatusPromo;
import com.example.marjanpromotionapi.Models.ResponsableRayon;
import com.example.marjanpromotionapi.Services.ResponsableRayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ResponsableRayon")
public class ResponsableRayonController {

    private final ResponsableRayonService responsableRayonService ;
    @Autowired
    public ResponsableRayonController(ResponsableRayonService responsableRayonService){
        this.responsableRayonService = responsableRayonService ;
    }
    @PostMapping("Promotion")
    public ResponseEntity<?> AccepterOuRefuserPromotion(@RequestBody PromotionRequest promotionRequest){
        System.out.println( promotionRequest.getPromotionId());
                System.out.println(promotionRequest.getResponsableId());
                        System.out.println(promotionRequest.getStatus());
        responsableRayonService.accepterOuRefuserPromotion(
                promotionRequest.getPromotionId(),
                promotionRequest.getResponsableId(),
                promotionRequest.getStatus());
        return ResponseEntity.ok().body("updated status");
    }

    @PostMapping("create")
    public ResponseEntity<ResponsableRayon> create(@RequestBody ResponsableRayon responsableRayon){
        return ResponseEntity.ok().body(responsableRayonService.create(responsableRayon));
    }
}
