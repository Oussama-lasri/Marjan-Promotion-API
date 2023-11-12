package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Services.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Promotion")
public class PromotionController {

    private final PromotionService promotionService ;
    public PromotionController(PromotionService promotionService){
        this.promotionService = promotionService ;
    }
    @GetMapping("/hello")
    public String welcome(){
        return "test test";
    }

    @PostMapping("/create")
    public ResponseEntity<Promotion> create(@RequestBody Promotion promotion){
        System.out.println(promotion.getCategorieId());
        promotionService.createPromotion(promotion , promotion.getCategorieId());
        return ResponseEntity.ok().body(promotion);
    }
}
