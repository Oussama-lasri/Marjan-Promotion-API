package com.example.marjanpromotionapi.DTO;

import com.example.marjanpromotionapi.Enums.StatusPromo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PromotionRequest {
    private Long responsableId;
    private Long promotionId;
    private StatusPromo status;
}
