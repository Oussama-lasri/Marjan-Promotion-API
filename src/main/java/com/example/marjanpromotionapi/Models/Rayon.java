package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Transactional
public class Rayon {
    @Id
    private Long id ;

    @ManyToOne
    private Centre centre;

    @OneToOne
    private ResponsableRayon responsableRayon;
}
