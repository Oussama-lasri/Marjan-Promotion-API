package com.example.marjanpromotionapi.Models;

import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Centre {
    @Id
    @GeneratedValue
    private Long id ;
    private String label ;
    private String ville ;
    @ManyToOne
    private AdminCentre adminCentre ;
}
