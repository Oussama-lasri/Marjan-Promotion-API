package com.example.marjanpromotionapi.Controllers;

import com.example.marjanpromotionapi.DTO.PromotionDTO;
import com.example.marjanpromotionapi.Models.Promotion;
import com.example.marjanpromotionapi.Services.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> create(@RequestBody Promotion promotion){
        promotionService.createPromotion(promotion , promotion.getCategorieId());
        return ResponseEntity.ok().body("promotion has been cerated");
    }


    @GetMapping("/all")
    public ResponseEntity<List<PromotionDTO>> all(){

        return ResponseEntity.ok().body(promotionService.promotionList());
    }

}
