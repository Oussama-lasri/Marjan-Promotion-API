package com.example.marjanpromotionapi.Models;

import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Transactional
public class Centre {
    @Id
    @GeneratedValue
    private Long id ;
    private String label ;
    private String ville ;
    @ManyToOne
    private AdminCentre adminCentre ;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "centre", cascade = CascadeType.MERGE)
    private List<ResponsableRayon> responsableRayonList ;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "centre", cascade = CascadeType.MERGE)
    private List<Rayon> rayonList ;
}
