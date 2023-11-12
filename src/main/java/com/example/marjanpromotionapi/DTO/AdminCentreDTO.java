package com.example.marjanpromotionapi.DTO;

import com.example.marjanpromotionapi.Models.Centre;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AdminCentreDTO {

    private Long id ;

    private String email ;

    private String password ;

    private List<Centre> centreList ;

   // private LocalDateTime createdOn ;
    // private LocalDateTime updatedOn ;
}
